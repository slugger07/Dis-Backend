package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserCulturalActivityAchievementDto;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.model.UserCulturalActivityAchievement;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserCulturalActivityAchievementService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserCulturalActivityAchievementService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);

        final List<UserCulturalActivityAchievementDto> userCulturalActivityAchievementDtoList =
                userProfileDtoMapper.convertUserCulturalActivityAchievementListModelIntoDto(
                userProfileRepo.getUserCulturalActivityAchievement(userId));

        return new ArrayList<>(userCulturalActivityAchievementDtoList);
    }

    public void addUserProfileElement(final UserCulturalActivityAchievementDto userCulturalActivityAchievementDto,
                                      final String token) {

        final UserCulturalActivityAchievement userCulturalActivityAchievement =
                userProfileDtoMapper.convertUserCulturalActivityAchievementDtoIntoModel(userCulturalActivityAchievementDto);

        if (Objects.isNull(userCulturalActivityAchievement.getId())) {

            userCulturalActivityAchievement.setCreatedBy(jwtResolver.getIdFromJwtToken(token));
            userCulturalActivityAchievement.setCreatedDate(new Date(new java.util.Date().getTime()));
        }

        userCulturalActivityAchievement.setModifiedBy(jwtResolver.getIdFromJwtToken(token));
        userCulturalActivityAchievement.setModifiedDate(new Date(new java.util.Date().getTime()));

        userCulturalActivityAchievement.setUserId(jwtResolver.getIdFromJwtToken(token));
        userProfileRepo.addOrUpdateUserCulturalActivityAchievement(userCulturalActivityAchievement);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) {
        userProfileRepo.deleteUserCulturalActivityAchievementById(id);
    }
}
