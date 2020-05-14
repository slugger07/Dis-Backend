package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserInternshipDto;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.model.UserInternship;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void addUserProfileElement(final UserInternshipDto userInternshipDto, final String token) {

        final UserInternship userInternship =
                userProfileDtoMapper.convertUserInternshipDtoIntoModel(userInternshipDto);

        if (Objects.isNull(userInternship.getId())) {

            userInternship.setCreatedBy(jwtResolver.getIdFromJwtToken(token));
            userInternship.setCreatedDate(new Date(new java.util.Date().getTime()));
        }

        userInternship.setModifiedBy(jwtResolver.getIdFromJwtToken(token));
        userInternship.setModifiedDate(new Date(new java.util.Date().getTime()));

        userInternship.setUserId(jwtResolver.getIdFromJwtToken(token));
        userProfileRepo.addOrUpdateUserInternship(userInternship);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) {
        userProfileRepo.deleteUserInternshipById(id);
    }
}
