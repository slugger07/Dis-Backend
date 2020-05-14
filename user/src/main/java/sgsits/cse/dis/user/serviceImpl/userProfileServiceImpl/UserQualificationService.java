package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserQualificationDto;
import sgsits.cse.dis.user.model.UserQualification;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserQualificationService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserQualificationService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);

        final List<UserQualificationDto> userQualificationDtoList =
                userProfileDtoMapper.convertUserQualificationListModelIntoDto(
                userProfileRepo.getUserQualification(userId));

        return new ArrayList<>(userQualificationDtoList);
    }

    public void addUserProfileElement(final UserQualificationDto userQualificationDto, final String token) {

        final UserQualification userQualification =
                userProfileDtoMapper.convertUserQualificationDtoIntoModel(userQualificationDto);

        if (Objects.isNull(userQualification.getId())) {

            userQualification.setCreatedBy(jwtResolver.getIdFromJwtToken(token));
            userQualification.setCreatedDate(new Date(new java.util.Date().getTime()));
        }

        userQualification.setModifiedBy(jwtResolver.getIdFromJwtToken(token));
        userQualification.setModifiedDate(new Date(new java.util.Date().getTime()));

        userQualification.setUserId(jwtResolver.getIdFromJwtToken(token));
        userProfileRepo.addOrUpdateUserQualification(userQualification);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) {
        userProfileRepo.deleteUserQualificationById(id);
    }
}
