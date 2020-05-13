package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserCompetitiveExamDto;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.model.UserCompetitiveExam;
import sgsits.cse.dis.user.service.UserProfileService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCompetitiveExamService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserCompetitiveExamService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);

        final List<UserCompetitiveExamDto> userCompetitiveExamDtoList =
                userProfileDtoMapper.convertUserCompetitiveExamListModelIntoDto(
                userProfileRepo.getUserCompetitiveExam(userId));

        return new ArrayList<>(userCompetitiveExamDtoList);
    }

    public void addUserProfileElement(final UserCompetitiveExamDto userCompetitiveExamDto) {

        final UserCompetitiveExam userCompetitiveExam =
                userProfileDtoMapper.convertUserCompetitiveExamDtoIntoModel(userCompetitiveExamDto);

        userProfileRepo.addOrUpdateUserCompetitiveExam(userCompetitiveExam);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) {
        userProfileRepo.deleteUserCompetitiveExamById(id);
    }
}
