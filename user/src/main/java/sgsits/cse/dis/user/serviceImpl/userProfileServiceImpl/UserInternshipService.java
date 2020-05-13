package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserInternshipDto;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.model.UserInternship;
import sgsits.cse.dis.user.service.UserProfileService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInternshipService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    public UserInternshipService(final UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String token) {

        final String userId = jwtResolver.getIdFromJwtToken(token);

        final List<UserInternshipDto> userInternshipDtoList =
                userProfileDtoMapper.convertUserInternshipListModelIntoDto(
                userProfileRepo.getUserInternship(userId));

        return new ArrayList<>(userInternshipDtoList);
    }

    public void addUserProfileElement(final UserInternshipDto userInternshipDto) {

        final UserInternship userInternship =
                userProfileDtoMapper.convertUserInternshipDtoIntoModel(userInternshipDto);

        userProfileRepo.addOrUpdateUserInternship(userInternship);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) {
        userProfileRepo.deleteUserInternshipById(id);
    }
}
