package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserCompetitiveExamDto;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.exception.UnauthorizedException;
import sgsits.cse.dis.user.model.UserCompetitiveExam;
import sgsits.cse.dis.user.model.UserWorkExperience;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("ConstantConditions")
@Service
public class UserCompetitiveExamService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserCompetitiveExamService(final UserProfileRepo userProfileRepo) {

        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String userId) throws InternalServerError {

        LOGGER.info("Fetching Exams info for user id : " + userId);

        final List<UserCompetitiveExamDto> userCompetitiveExamDtoList =
                userProfileDtoMapper.convertUserCompetitiveExamListModelIntoDto(
                userProfileRepo.getUserCompetitiveExam(userId));

        LOGGER.info(userCompetitiveExamDtoList.toString());

        return new ArrayList<>(userCompetitiveExamDtoList);
    }


    public void addUserProfileElement(final UserCompetitiveExamDto userCompetitiveExamDto,
                                      final String token) throws InternalServerError, UnauthorizedException {

        final UserCompetitiveExam userCompetitiveExam =
                userProfileDtoMapper.convertUserCompetitiveExamDtoIntoModel(userCompetitiveExamDto);

        LOGGER.info("Adding or Updating userElement for id : " + userCompetitiveExam.getUserId());

        final String userId = jwtResolver.getIdFromJwtToken(token);

        if (0 == userCompetitiveExam.getId()) {

            userCompetitiveExam.setCreatedBy(userId);
            userCompetitiveExam.setCreatedDate(new Date(new java.util.Date().getTime()));
        }  else {

            final UserCompetitiveExam userCompetitiveExamExisting = userProfileRepo
                    .getUserCompetitiveExamById(userCompetitiveExam.getId());

            if(!userCompetitiveExamExisting.getUserId().equals(userId)) {

                throw new UnauthorizedException("You aren't authorized to edit this");
            }

            userCompetitiveExam.setCreatedBy(userCompetitiveExamExisting.getCreatedBy());
            userCompetitiveExam.setCreatedDate(userCompetitiveExamExisting.getCreatedDate());
        }

        userCompetitiveExam.setModifiedBy(userId);
        userCompetitiveExam.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserCompetitiveExam(userCompetitiveExam);
    }


    @Override
    public void deleteUserProfileElementById(final Long id, final String token)
            throws InternalServerError, UnauthorizedException {

        LOGGER.info("Deleting Competitive Exam for user id : " + jwtResolver.getIdFromJwtToken(token));

        final UserCompetitiveExam userCompetitiveExam =
                userProfileRepo.getUserCompetitiveExamById(id);

        if (jwtResolver.getIdFromJwtToken(token).equals(userCompetitiveExam.getUserId())) {

            userProfileRepo.deleteUserCompetitiveExamById(id);
        } else {
            throw new UnauthorizedException("You are not authorized to delete this");
        }
    }
}
