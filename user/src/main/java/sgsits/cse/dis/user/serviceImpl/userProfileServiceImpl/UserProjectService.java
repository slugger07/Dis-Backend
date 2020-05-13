package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserProjectDto;
import sgsits.cse.dis.user.dtos.UserQualificationDto;
import sgsits.cse.dis.user.model.UserProject;
import sgsits.cse.dis.user.model.UserQualification;
import sgsits.cse.dis.user.service.UserProfileService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProjectService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserProjectService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);

        final List<UserProjectDto> userProjectDtoList =
                userProfileDtoMapper.convertUserProjectListModelIntoDto(
                userProfileRepo.getUserProject(userId));

        return new ArrayList<>(userProjectDtoList);
    }

    public void addUserProfileElement(final UserProjectDto userProjectDto) {

        final UserProject userProject =
                userProfileDtoMapper.convertUserProjectDtoIntoModel(userProjectDto);

        userProfileRepo.addOrUpdateUserProject(userProject);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) {
        userProfileRepo.deleteUserProjectById(id);
    }
}
