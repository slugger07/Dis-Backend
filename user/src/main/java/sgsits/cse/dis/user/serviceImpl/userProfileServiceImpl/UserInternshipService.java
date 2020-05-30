package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserInternshipDto;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.exception.UnauthorizedException;
import sgsits.cse.dis.user.model.UserInternship;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserInternshipService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserInternshipService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String userId) throws InternalServerError {

        LOGGER.info("Fetching Internships info for user id : " + userId);

        final List<UserInternshipDto> userInternshipDtoList =
                userProfileDtoMapper.convertUserInternshipListModelIntoDto(
                userProfileRepo.getUserInternship(userId));

        return new ArrayList<>(userInternshipDtoList);
    }

    public void addUserProfileElement(final UserInternshipDto userInternshipDto,
                                      final String token) throws InternalServerError, UnauthorizedException {

        final UserInternship userInternship =
                userProfileDtoMapper.convertUserInternshipDtoIntoModel(userInternshipDto);

        LOGGER.info("Adding or Updating userElement for id : " + userInternship.getUserId());

        final String userId = jwtResolver.getIdFromJwtToken(token);

        if (0 == userInternship.getId()) {

            userInternship.setCreatedBy(userId);
            userInternship.setCreatedDate(new Date(new java.util.Date().getTime()));
        }  else {

            final UserInternship userInternshipExisting = userProfileRepo
                    .getUserInternshipById(userInternship.getId());

            if(!userInternshipExisting.getUserId().equals(userId)) {

                throw new UnauthorizedException("You aren't authorized to edit this");
            }

            userInternship.setCreatedBy(userInternshipExisting.getCreatedBy());
            userInternship.setCreatedDate(userInternshipExisting.getCreatedDate());
        }

        userInternship.setModifiedBy(userId);
        userInternship.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserInternship(userInternship);
    }


    @Override
    public void deleteUserProfileElementById(final Long id, final String token)
            throws InternalServerError, UnauthorizedException {

        LOGGER.info("Deleting Internship for user id : " + jwtResolver.getIdFromJwtToken(token));

        final UserInternship userInternship =
                userProfileRepo.getUserInternshipById(id);

        if (jwtResolver.getIdFromJwtToken(token).equals(userInternship.getUserId())) {

            userProfileRepo.deleteUserInternshipById(id);
        } else {
            throw new UnauthorizedException("You are not authorized to delete this");
        }
    }
}
