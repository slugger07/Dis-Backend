package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserWorkExperienceDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.exception.UnauthorizedException;
import sgsits.cse.dis.user.model.UserWorkExperience;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("DuplicatedCode")
@Service
public class UserWorkExperienceService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserWorkExperienceService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String userId) throws InternalServerError {

        LOGGER.info("Fetching Work Experience info for user id : " + userId);

        final List<UserWorkExperienceDto> userWorkExperienceDtoList =
                userProfileDtoMapper.convertUserWorkExperienceListModelIntoDto(
                userProfileRepo.getUserWorkExperience(userId));

        return new ArrayList<>(userWorkExperienceDtoList);
    }

    public void addUserProfileElement(final UserWorkExperienceDto userWorkExperienceDto,
                                      final String token) throws InternalServerError, UnauthorizedException {

        final UserWorkExperience userWorkExperience =
                userProfileDtoMapper.convertUserWorkExperienceDtoIntoModel(userWorkExperienceDto);

        LOGGER.info("Adding or Updating userElement for id : " + userWorkExperience.getUserId());

        final String userId = jwtResolver.getIdFromJwtToken(token);

        if (0 == userWorkExperience.getId()) {

            userWorkExperience.setCreatedBy(userId);
            userWorkExperience.setCreatedDate(new Date(new java.util.Date().getTime()));
        }  else {

            final UserWorkExperience userWorkExperienceExisting = userProfileRepo
                    .getUserWorkExperienceById(userWorkExperience.getId());

            if(!userWorkExperienceExisting.getUserId().equals(userId)) {

                throw new UnauthorizedException("You aren't authorized to edit this");
            }

            userWorkExperience.setCreatedBy(userWorkExperienceExisting.getCreatedBy());
            userWorkExperience.setCreatedDate(userWorkExperienceExisting.getCreatedDate());
        }

        userWorkExperience.setModifiedBy(userId);
        userWorkExperience.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserWorkExperience(userWorkExperience);
    }


    @Override
    public void deleteUserProfileElementById(final Long id, final String token)
            throws InternalServerError, UnauthorizedException {


        LOGGER.info("Deleting Work Experience for user id : " + jwtResolver.getIdFromJwtToken(token));

        final UserWorkExperience userWorkExperience =
                userProfileRepo.getUserWorkExperienceById(id);

        if (jwtResolver.getIdFromJwtToken(token).equals(userWorkExperience.getUserId())) {

            userProfileRepo.deleteUserWorkExperienceById(id);
        } else {
            throw new UnauthorizedException("You are not authorized to delete this");
        }
    }
}
