package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserTechnicalActivityDto;
import sgsits.cse.dis.user.model.UserTechnicalActivity;
import sgsits.cse.dis.user.service.UserProfileService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserTechnicalActivityService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserTechnicalActivityService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);

        final List<UserTechnicalActivityDto> userTechnicalActivityDtoList =
                userProfileDtoMapper.convertUserTechnicalActivityListModelIntoDto(
                userProfileRepo.getUserTechnicalActivity(userId));

        return new ArrayList<>(userTechnicalActivityDtoList);
    }

    public void addUserProfileElement(final UserTechnicalActivityDto userTechnicalActivityDto) {

        final UserTechnicalActivity userTechnicalActivity =
                userProfileDtoMapper.convertUserTechnicalActivityDtoIntoModel(userTechnicalActivityDto);

        userProfileRepo.addOrUpdateUserTechnicalActivity(userTechnicalActivity);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) {
        userProfileRepo.deleteUserTechnicalActivityById(id);
    }
}
