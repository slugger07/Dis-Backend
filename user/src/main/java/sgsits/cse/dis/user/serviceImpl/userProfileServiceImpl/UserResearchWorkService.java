package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserResearchWorkDto;
import sgsits.cse.dis.user.dtos.UserWorkExperienceDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.model.UserResearchWork;
import sgsits.cse.dis.user.model.UserWorkExperience;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserResearchWorkService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserResearchWorkService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String userId) throws InternalServerError {

        LOGGER.info("Fetching research work info for user id : " + userId);

        final List<UserResearchWorkDto> userResearchWorkDtoList =
                userProfileDtoMapper.convertUserResearchWorkListModelIntoDto(
                userProfileRepo.getUserResearchWork(userId));

        return new ArrayList<>(userResearchWorkDtoList);
    }

    public void addUserProfileElement(final UserResearchWorkDto userResearchWorkDto,
                                      final String token) throws InternalServerError {

        final UserResearchWork userResearchWork =
                userProfileDtoMapper.convertUserResearchWorkDtoIntoModel(userResearchWorkDto);

        LOGGER.info("Adding or Updating userElement for id : " + userResearchWork.getUserId());


        if (0 == userResearchWork.getId()) {

            userResearchWork.setCreatedBy(jwtResolver.getIdFromJwtToken(token));
            userResearchWork.setCreatedDate(new Date(new java.util.Date().getTime()));
        } else {

            final UserResearchWork userResearchWorkExisting = userProfileRepo
                    .getUserResearchWorkById(userResearchWork.getId());
            userResearchWork.setCreatedBy(userResearchWorkExisting.getCreatedBy());
            userResearchWork.setCreatedDate(userResearchWorkExisting.getCreatedDate());
        }

        userResearchWork.setModifiedBy(jwtResolver.getIdFromJwtToken(token));
        userResearchWork.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserResearchWork(userResearchWork);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) throws InternalServerError {
        userProfileRepo.deleteUserResearchWorkById(id);
    }
}
