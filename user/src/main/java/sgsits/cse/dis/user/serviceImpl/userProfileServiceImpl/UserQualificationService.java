package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserQualificationDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.model.UserQualification;
import sgsits.cse.dis.user.model.UserWorkExperience;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserQualificationService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserQualificationService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }

    private final static Logger LOGGER = LoggerFactory.getLogger(UserQualificationService.class);


    @Override
    public List<UserProfileDto> getUserProfileElement(final String userId) throws InternalServerError {

        LOGGER.info("Fetching qualification info for user id : " + userId);

        final List<UserQualificationDto> userQualificationDtoList =
                userProfileDtoMapper.convertUserQualificationListModelIntoDto(
                userProfileRepo.getUserQualification(userId));

        return new ArrayList<>(userQualificationDtoList);
    }

    public void addUserProfileElement(final UserQualificationDto userQualificationDto, final String token) throws InternalServerError {

        final UserQualification userQualification =
                userProfileDtoMapper.convertUserQualificationDtoIntoModel(userQualificationDto);

        LOGGER.info("Adding or Updating userElement for id : " + userQualification.getUserId());

        if (0 == userQualification.getId()) {

            userQualification.setCreatedBy(jwtResolver.getIdFromJwtToken(token));
            userQualification.setCreatedDate(new Date(new java.util.Date().getTime()));
        } else {

            final UserQualification userQualificationExisting = userProfileRepo
                    .getUserQualificationById(userQualification.getId());
            userQualification.setCreatedBy(userQualificationExisting.getCreatedBy());
            userQualification.setCreatedDate(userQualificationExisting.getCreatedDate());
        }

        userQualification.setModifiedBy(jwtResolver.getIdFromJwtToken(token));
        userQualification.setModifiedDate(new Date(new java.util.Date().getTime()));

        userQualification.setUserId(jwtResolver.getIdFromJwtToken(token));
        userProfileRepo.addOrUpdateUserQualification(userQualification);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) throws InternalServerError {



        userProfileRepo.deleteUserQualificationById(id);
    }
}
