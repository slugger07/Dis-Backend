package sgsits.cse.dis.user.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.ProfilePictureDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.exception.NotFoundException;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.model.ProfilePicture;
import sgsits.cse.dis.user.utility.CompressionUtility;
import sgsits.cse.dis.user.utility.GenericBuilder;

import java.io.IOException;
import java.sql.Date;

@Component
public class ProfilePictureService {

    private final JwtResolver jwtResolver = new JwtResolver();
    private final UserProfileRepo userProfileRepo;
    private final static Logger LOGGER = LoggerFactory.getLogger(ProfilePictureService.class);

    public ProfilePictureService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }

    public void addOrUpdateProfilePicture(final MultipartFile file, final String jwtToken)
            throws IOException, InternalServerError {

        final String userId = jwtResolver.getIdFromJwtToken(jwtToken);

        deactivateOtherProfilePicture(userId);

        final ProfilePicture profilePicture = GenericBuilder.of(ProfilePicture::new)
                .with(ProfilePicture::setCreatedBy, userId)
                .with(ProfilePicture::setCreatedDate, new Date(new java.util.Date().getTime()))
                .with(ProfilePicture::setModifiedBy, userId)
                .with(ProfilePicture::setModifiedDate, new Date(new java.util.Date().getTime()))
                .with(ProfilePicture::setFileName, file.getOriginalFilename())
                .with(ProfilePicture::setFileType, file.getContentType())
                .with(ProfilePicture::setPicByte, CompressionUtility.compressBytes(file.getBytes()))
                .with(ProfilePicture::setStatus, 1)
                .with(ProfilePicture::setUserId, userId)
                .build();

        userProfileRepo.addOrUpdateUserProfilePicture(profilePicture);
    }


    public ProfilePictureDto getUserProfilePicture(final String userId, final float compressionFactor)
            throws InternalServerError, NotFoundException {

        ProfilePicture profilePicture;

        try{
            LOGGER.info("Getting Profile Pictures for user Id : " + userId);

            profilePicture = userProfileRepo.getActiveProfilePictureByUserId(userId).get(0);
        } catch (Exception e) {
            throw new NotFoundException("Profile Picture Doesn't Exist");
        }

        return GenericBuilder.of(ProfilePictureDto::new)
                .with(ProfilePictureDto::setId, profilePicture.getId())
                .with(ProfilePictureDto::setName, profilePicture.getFileName())
                .with(ProfilePictureDto::setType, profilePicture.getFileType())
                .with(ProfilePictureDto::setPicByte, CompressionUtility.decompressBytes(
                        profilePicture.getPicByte()))
                .build();

    }

    private void deactivateOtherProfilePicture(final String userId) throws InternalServerError {

        userProfileRepo.getActiveProfilePictureByUserId(userId)
                .forEach(profilePicture -> {
                    profilePicture.setStatus(0);
                    try {
                        userProfileRepo.addOrUpdateUserProfilePicture(profilePicture);
                    } catch (InternalServerError internalServerError) {
                        internalServerError.printStackTrace();
                    }
                });
    }



}
