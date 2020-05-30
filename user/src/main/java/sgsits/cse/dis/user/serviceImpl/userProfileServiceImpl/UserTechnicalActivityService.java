package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserTechnicalActivityDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.exception.UnauthorizedException;
import sgsits.cse.dis.user.model.UserTechnicalActivity;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserTechnicalActivityService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserTechnicalActivityService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String userId) throws InternalServerError {

        LOGGER.info("Fetching technical activities info for user id : " + userId);

        final List<UserTechnicalActivityDto> userTechnicalActivityDtoList =
                userProfileDtoMapper.convertUserTechnicalActivityListModelIntoDto(
                userProfileRepo.getUserTechnicalActivity(userId));

        return new ArrayList<>(userTechnicalActivityDtoList);
    }

    public void addUserProfileElement(final UserTechnicalActivityDto userTechnicalActivityDto,
                                      final String token) throws InternalServerError, UnauthorizedException {

        final UserTechnicalActivity userTechnicalActivity =
                userProfileDtoMapper.convertUserTechnicalActivityDtoIntoModel(userTechnicalActivityDto);

        LOGGER.info("Adding or Updating userElement for id : " + userTechnicalActivity.getUserId());

        final String userId = jwtResolver.getIdFromJwtToken(token);

        if (0 == userTechnicalActivity.getId()) {

            userTechnicalActivity.setCreatedBy(userId);
            userTechnicalActivity.setCreatedDate(new Date(new java.util.Date().getTime()));
        }  else {

            final UserTechnicalActivity userTechnicalActivityExisting = userProfileRepo
                    .getUserTechnicalActivityById(userTechnicalActivity.getId());

            if(!userTechnicalActivityExisting.getUserId().equals(userId)) {

                throw new UnauthorizedException("You aren't authorized to edit this");
            }

            userTechnicalActivity.setCreatedBy(userTechnicalActivityExisting.getCreatedBy());
            userTechnicalActivity.setCreatedDate(userTechnicalActivityExisting.getCreatedDate());
        }

        userTechnicalActivity.setModifiedBy(userId);
        userTechnicalActivity.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserTechnicalActivity(userTechnicalActivity);
    }


    @Override
    public void deleteUserProfileElementById(final Long id, final String token)
            throws InternalServerError, UnauthorizedException {

        LOGGER.info("Deleting Technical Activity for user id : " + jwtResolver.getIdFromJwtToken(token));


        final UserTechnicalActivity userTechnicalActivity =
                userProfileRepo.getUserTechnicalActivityById(id);

        if (jwtResolver.getIdFromJwtToken(token).equals(userTechnicalActivity.getUserId())) {

            userProfileRepo.deleteUserTechnicalActivityById(id);
        } else {
            throw new UnauthorizedException("You are not authorized to delete this");
        }
    }
}
