package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserResearchWorkDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.exception.UnauthorizedException;
import sgsits.cse.dis.user.model.UserResearchWork;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
                                      final String token) throws InternalServerError, UnauthorizedException {

        final UserResearchWork userResearchWork =
                userProfileDtoMapper.convertUserResearchWorkDtoIntoModel(userResearchWorkDto);

        LOGGER.info("Adding or Updating userElement for id : " + userResearchWork.getUserId());

        final String userId = jwtResolver.getIdFromJwtToken(token);

        if (0 == userResearchWork.getId()) {

            userResearchWork.setCreatedBy(userId);
            userResearchWork.setCreatedDate(new Date(new java.util.Date().getTime()));
        }  else {

            final UserResearchWork userResearchWorkExisting = userProfileRepo
                    .getUserResearchWorkById(userResearchWork.getId());

            if(!userResearchWorkExisting.getUserId().equals(userId)) {

                throw new UnauthorizedException("You aren't authorized to edit this");
            }

            userResearchWork.setCreatedBy(userResearchWorkExisting.getCreatedBy());
            userResearchWork.setCreatedDate(userResearchWorkExisting.getCreatedDate());
        }

        userResearchWork.setModifiedBy(userId);
        userResearchWork.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserResearchWork(userResearchWork);
    }


    @Override
    public void deleteUserProfileElementById(final Long id, final String token)
            throws InternalServerError, UnauthorizedException {

        LOGGER.info("Deleting Research Work for user id : " + jwtResolver.getIdFromJwtToken(token));

        final UserResearchWork userResearchWork =
                userProfileRepo.getUserResearchWorkById(id);

        if (jwtResolver.getIdFromJwtToken(token).equals(userResearchWork.getUserId())) {

            userProfileRepo.deleteUserResearchWorkById(id);
        } else {
            throw new UnauthorizedException("You are not authorized to delete this");
        }
    }
}
