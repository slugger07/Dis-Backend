package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserResearchWorkDto;
import sgsits.cse.dis.user.dtos.UserWorkExperienceDto;
import sgsits.cse.dis.user.model.UserResearchWork;
import sgsits.cse.dis.user.model.UserWorkExperience;
import sgsits.cse.dis.user.service.UserProfileService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserResearchWorkService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserResearchWorkService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);

        final List<UserResearchWorkDto> userResearchWorkDtoList =
                userProfileDtoMapper.convertUserResearchWorkListModelIntoDto(
                userProfileRepo.getUserResearchWork(userId));

        return new ArrayList<>(userResearchWorkDtoList);
    }

    public void addUserProfileElement(final UserResearchWorkDto userResearchWorkDto) {

        final UserResearchWork userResearchWork =
                userProfileDtoMapper.convertUserResearchWorkDtoIntoModel(userResearchWorkDto);

        userProfileRepo.addOrUpdateUserResearchWork(userResearchWork);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) {
        userProfileRepo.deleteUserResearchWorkById(id);
    }
}
