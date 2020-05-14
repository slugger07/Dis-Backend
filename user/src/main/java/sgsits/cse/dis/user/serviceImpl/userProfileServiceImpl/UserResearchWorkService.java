package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserResearchWorkDto;
import sgsits.cse.dis.user.dtos.UserWorkExperienceDto;
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
    public List<UserProfileDto> getUserProfileElement(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);

        final List<UserResearchWorkDto> userResearchWorkDtoList =
                userProfileDtoMapper.convertUserResearchWorkListModelIntoDto(
                userProfileRepo.getUserResearchWork(userId));

        return new ArrayList<>(userResearchWorkDtoList);
    }

    public void addUserProfileElement(final UserResearchWorkDto userResearchWorkDto,
                                      final String token) {

        final UserResearchWork userResearchWork =
                userProfileDtoMapper.convertUserResearchWorkDtoIntoModel(userResearchWorkDto);

        if (Objects.isNull(userResearchWork.getId())) {

            userResearchWork.setCreatedBy(jwtResolver.getIdFromJwtToken(token));
            userResearchWork.setCreatedDate(new Date(new java.util.Date().getTime()));
        }

        userResearchWork.setModifiedBy(jwtResolver.getIdFromJwtToken(token));
        userResearchWork.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserResearchWork(userResearchWork);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) {
        userProfileRepo.deleteUserResearchWorkById(id);
    }
}
