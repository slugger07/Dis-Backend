package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserCulturalActivityAchievementDto;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.exception.UnauthorizedException;
import sgsits.cse.dis.user.model.UserCulturalActivityAchievement;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserCulturalActivityAchievementService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    private final static Logger LOGGER = LoggerFactory.getLogger(UserCulturalActivityAchievement.class);

    public UserCulturalActivityAchievementService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String userId) throws InternalServerError {

        LOGGER.info("fetching cultural Achievements for user id : " + userId);

        final List<UserCulturalActivityAchievementDto> userCulturalActivityAchievementDtoList =
                userProfileDtoMapper.convertUserCulturalActivityAchievementListModelIntoDto(
                userProfileRepo.getUserCulturalActivityAchievement(userId));

        LOGGER.info(String.valueOf(userCulturalActivityAchievementDtoList));

        return new ArrayList<>(userCulturalActivityAchievementDtoList);
    }

    public void addUserProfileElement(final UserCulturalActivityAchievementDto userCulturalActivityAchievementDto,
                                      final String token) throws InternalServerError, UnauthorizedException {

        final UserCulturalActivityAchievement userCulturalActivityAchievement =
                userProfileDtoMapper.convertUserCulturalActivityAchievementDtoIntoModel(userCulturalActivityAchievementDto);

        LOGGER.info("Adding or Updating userElement for id : " + userCulturalActivityAchievement.getUserId());

        final String userId = jwtResolver.getIdFromJwtToken(token);

        if (0 == userCulturalActivityAchievement.getId()) {

            userCulturalActivityAchievement.setCreatedBy(userId);
            userCulturalActivityAchievement.setCreatedDate(new Date(new java.util.Date().getTime()));
        }  else {

            final UserCulturalActivityAchievement userCulturalActivityAchievementExisting = userProfileRepo
                    .getUserCulturalActivityAchievementById(userCulturalActivityAchievement.getId());

            if(!userCulturalActivityAchievementExisting.getUserId().equals(userId)) {

                throw new UnauthorizedException("You aren't authorized to edit this");
            }

            userCulturalActivityAchievement.setCreatedBy(userCulturalActivityAchievementExisting.getCreatedBy());
            userCulturalActivityAchievement.setCreatedDate(userCulturalActivityAchievementExisting.getCreatedDate());
        }

        userCulturalActivityAchievement.setModifiedBy(userId);
        userCulturalActivityAchievement.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserCulturalActivityAchievement(userCulturalActivityAchievement);
    }


    @Override
    public void deleteUserProfileElementById(final Long id, final String token)
            throws InternalServerError, UnauthorizedException {

        LOGGER.info("Deleting Cultural Activity for user id : " + jwtResolver.getIdFromJwtToken(token));

        final UserCulturalActivityAchievement userCulturalActivityAchievement =
                userProfileRepo.getUserCulturalActivityAchievementById(id);

        if (jwtResolver.getIdFromJwtToken(token).equals(userCulturalActivityAchievement.getUserId())) {

            userProfileRepo.deleteUserCulturalActivityAchievementById(id);
        } else {
            throw new UnauthorizedException("You are not authorized to delete this");
        }
    }
}
