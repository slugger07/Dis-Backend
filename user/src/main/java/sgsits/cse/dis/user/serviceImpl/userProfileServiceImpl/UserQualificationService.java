package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.dtos.UserQualificationDto;
import sgsits.cse.dis.user.model.UserQualification;
import sgsits.cse.dis.user.service.UserProfileService;

import java.util.ArrayList;
import java.util.List;

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

    public void addUserProfileElement(final UserQualificationDto userQualificationDto) {

        final UserQualification userQualification =
                userProfileDtoMapper.convertUserQualificationDtoIntoModel(userQualificationDto);

        userProfileRepo.addOrUpdateUserQualification(userQualification);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) {
        userProfileRepo.deleteUserQualificationById(id);
    }
}
