package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserCulturalActivityAchievementDto;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserProjectDto;
import sgsits.cse.dis.user.model.UserCulturalActivityAchievement;
import sgsits.cse.dis.user.model.UserProject;
import sgsits.cse.dis.user.service.UserProfileService;

import java.util.ArrayList;
import java.util.List;

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

    public void addUserProfileElement(final UserCulturalActivityAchievementDto userCulturalActivityAchievementDto) {

        final UserCulturalActivityAchievement userCulturalActivityAchievement =
                userProfileDtoMapper.convertUserCulturalActivityAchievementDtoIntoModel(userCulturalActivityAchievementDto);

        userProfileRepo.addOrUpdateUserCulturalActivityAchievement(userCulturalActivityAchievement);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) {
        userProfileRepo.deleteUserCulturalActivityAchievementById(id);
    }
}
