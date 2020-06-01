package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserOtherAchievementDto;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.exception.UnauthorizedException;
import sgsits.cse.dis.user.model.UserOtherAchievement;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserOtherAchievementService implements UserProfileService {


    private final UserProfileRepo userProfileRepo;

    public UserOtherAchievementService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String userId) throws InternalServerError {

        LOGGER.info("Fetching OtherAchievements info for user id : " + userId);

        final List<UserOtherAchievementDto> userOtherAchievementDtoList =
                userProfileDtoMapper.convertUserOtherAchievementListModelIntoDto(
                        userProfileRepo.getUserOtherAchievement(userId));

        return new ArrayList<>(userOtherAchievementDtoList);
    }

    public void addUserProfileElement(final UserOtherAchievementDto userOtherAchievementDto,
                                      final String token) throws InternalServerError, UnauthorizedException {

        final UserOtherAchievement userOtherAchievement =
                userProfileDtoMapper.convertUserOtherAchievementDtoIntoModel(userOtherAchievementDto);

        LOGGER.info("Adding or Updating userElement for id : " + userOtherAchievement.getUserId());

        final String userId = jwtResolver.getIdFromJwtToken(token);

        if (0 == userOtherAchievement.getId()) {

            userOtherAchievement.setCreatedBy(userId);
            userOtherAchievement.setCreatedDate(new Date(new java.util.Date().getTime()));
        }  else {

            final UserOtherAchievement userOtherAchievementExisting = userProfileRepo
                    .getUserOtherAchievementById(userOtherAchievement.getId());

            if(!userOtherAchievementExisting.getUserId().equals(userId)) {

                throw new UnauthorizedException("You aren't authorized to edit this");
            }

            userOtherAchievement.setCreatedBy(userOtherAchievementExisting.getCreatedBy());
            userOtherAchievement.setCreatedDate(userOtherAchievementExisting.getCreatedDate());
        }

        userOtherAchievement.setModifiedBy(userId);
        userOtherAchievement.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserOtherAchievement(userOtherAchievement);
    }


    @Override
    public void deleteUserProfileElementById(final Long id, final String token)
            throws InternalServerError, UnauthorizedException {

        LOGGER.info("Deleting OtherAchievement for user id : " + jwtResolver.getIdFromJwtToken(token));

        final UserOtherAchievement userOtherAchievement =
                userProfileRepo.getUserOtherAchievementById(id);

        if (jwtResolver.getIdFromJwtToken(token).equals(userOtherAchievement.getUserId())) {

            userProfileRepo.deleteUserOtherAchievementById(id);
        } else {
            throw new UnauthorizedException("You are not authorized to delete this");
        }
    }
}
