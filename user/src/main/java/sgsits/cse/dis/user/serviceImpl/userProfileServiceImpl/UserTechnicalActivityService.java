package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserTechnicalActivityDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.model.UserTechnicalActivity;
import sgsits.cse.dis.user.service.UserProfileService;
import sgsits.cse.dis.user.utility.GenericBuilder;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserTechnicalActivityService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserTechnicalActivityService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String userId) throws InternalServerError {

        LOGGER.info("Fetching technical activities info for user id : " + userId);

        final List<UserTechnicalActivityDto> userTechnicalActivityDtoList =
                userProfileDtoMapper.convertUserTechnicalActivityListModelIntoDto(
                userProfileRepo.getUserTechnicalActivity(userId));

        return new ArrayList<>(userTechnicalActivityDtoList);
    }

    public void addUserProfileElement(final UserTechnicalActivityDto userTechnicalActivityDto,
                                      final String token) throws InternalServerError {

        final UserTechnicalActivity userTechnicalActivity =
                userProfileDtoMapper.convertUserTechnicalActivityDtoIntoModel(userTechnicalActivityDto);

        LOGGER.info("Adding or Updating userElement for id : " + userTechnicalActivity.getUserId());

        if (0 == userTechnicalActivity.getId()) {

            userTechnicalActivity.setCreatedBy(jwtResolver.getIdFromJwtToken(token));
            userTechnicalActivity.setCreatedDate(new Date(new java.util.Date().getTime()));
        }

        userTechnicalActivity.setModifiedBy(jwtResolver.getIdFromJwtToken(token));
        userTechnicalActivity.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserTechnicalActivity(userTechnicalActivity);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) throws InternalServerError {

        userProfileRepo.deleteUserTechnicalActivityById(id);
    }
}
