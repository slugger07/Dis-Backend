package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserProjectDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.exception.UnauthorizedException;
import sgsits.cse.dis.user.model.UserProject;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    public void addUserProfileElement(final UserProjectDto userProjectDto,
                                      final String token) throws InternalServerError, UnauthorizedException {

        final UserProject userProject =
                userProfileDtoMapper.convertUserProjectDtoIntoModel(userProjectDto);

        LOGGER.info("Adding or Updating userElement for id : " + userProject.getUserId());

        final String userId = jwtResolver.getIdFromJwtToken(token);

        if (0 == userProject.getId()) {

            userProject.setCreatedBy(userId);
            userProject.setCreatedDate(new Date(new java.util.Date().getTime()));
        }  else {

            final UserProject userProjectExisting = userProfileRepo
                    .getUserProjectById(userProject.getId());

            if(!userProjectExisting.getUserId().equals(userId)) {

                throw new UnauthorizedException("You aren't authorized to edit this");
            }

            userProject.setCreatedBy(userProjectExisting.getCreatedBy());
            userProject.setCreatedDate(userProjectExisting.getCreatedDate());
        }

        userProject.setModifiedBy(userId);
        userProject.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserProject(userProject);
    }


    @Override
    public void deleteUserProfileElementById(final Long id, final String token)
            throws InternalServerError, UnauthorizedException {

        LOGGER.info("Deleting Project for user id : " + jwtResolver.getIdFromJwtToken(token));

        final UserProject userProject =
                userProfileRepo.getUserProjectById(id);

        if (jwtResolver.getIdFromJwtToken(token).equals(userProject.getUserId())) {

            userProfileRepo.deleteUserProjectById(id);
        } else {
            throw new UnauthorizedException("You are not authorized to delete this");
        }
    }
}
