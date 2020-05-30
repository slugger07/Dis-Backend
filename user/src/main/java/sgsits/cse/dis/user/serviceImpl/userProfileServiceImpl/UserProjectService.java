package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserProjectDto;
import sgsits.cse.dis.user.dtos.UserQualificationDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.model.UserProject;
import sgsits.cse.dis.user.model.UserQualification;
import sgsits.cse.dis.user.model.UserWorkExperience;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserProjectService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserProjectService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String userId) throws InternalServerError {

        LOGGER.info("Fetching projects info for user id : " + userId);

        final List<UserProjectDto> userProjectDtoList =
                userProfileDtoMapper.convertUserProjectListModelIntoDto(
                userProfileRepo.getUserProject(userId));

        return new ArrayList<>(userProjectDtoList);
    }

    public void addUserProfileElement(final UserProjectDto userProjectDto, final String token) throws InternalServerError {

        final UserProject userProject =
                userProfileDtoMapper.convertUserProjectDtoIntoModel(userProjectDto);

        LOGGER.info("Adding or Updating userElement for id : " + userProject.getUserId());

        if (0 == userProject.getId()) {

            userProject.setCreatedBy(jwtResolver.getIdFromJwtToken(token));
            userProject.setCreatedDate(new Date(new java.util.Date().getTime()));
        }  else {

            final UserProject userProjectExisting = userProfileRepo
                    .getUserProjectById(userProject.getId());
            userProject.setCreatedBy(userProjectExisting.getCreatedBy());
            userProject.setCreatedDate(userProjectExisting.getCreatedDate());
        }

        userProject.setModifiedBy(jwtResolver.getIdFromJwtToken(token));
        userProject.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProject.setUserId(jwtResolver.getIdFromJwtToken(token));
        userProfileRepo.addOrUpdateUserProject(userProject);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) throws InternalServerError {
        userProfileRepo.deleteUserProjectById(id);
    }
}
