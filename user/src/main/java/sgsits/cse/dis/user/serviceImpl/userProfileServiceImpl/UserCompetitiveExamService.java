package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserCompetitiveExamDto;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.model.UserCompetitiveExam;
import sgsits.cse.dis.user.model.UserWorkExperience;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
                                      final String token) throws InternalServerError {

        final UserCompetitiveExam userCompetitiveExam =
                userProfileDtoMapper.convertUserCompetitiveExamDtoIntoModel(userCompetitiveExamDto);

        LOGGER.info("Adding or Updating userElement for id : " + userCompetitiveExam.getUserId());

        if (0 == userCompetitiveExam.getId()) {

            userCompetitiveExam.setCreatedBy(jwtResolver.getIdFromJwtToken(token));
            userCompetitiveExam.setCreatedDate(new Date(new java.util.Date().getTime()));
        }  else {

            final UserCompetitiveExam userCompetitiveExamExisting = userProfileRepo
                    .getUserCompetitiveExamById(userCompetitiveExam.getId());
            userCompetitiveExam.setCreatedBy(userCompetitiveExamExisting.getCreatedBy());
            userCompetitiveExam.setCreatedDate(userCompetitiveExamExisting.getCreatedDate());
        }

        userCompetitiveExam.setModifiedBy(jwtResolver.getIdFromJwtToken(token));
        userCompetitiveExam.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserCompetitiveExam(userCompetitiveExam);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) throws InternalServerError {

        userProfileRepo.deleteUserCompetitiveExamById(id);
    }
}
