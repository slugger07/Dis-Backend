package sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.components.UserProfileRepo;
import sgsits.cse.dis.user.dtos.UserAddressDto;
import sgsits.cse.dis.user.dtos.UserProfileDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.model.UserAddress;
import sgsits.cse.dis.user.service.UserProfileService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ConstantConditions")
@Service
public class UserAddressService implements UserProfileService {

    private final UserProfileRepo userProfileRepo;

    private final static Logger LOGGER = LoggerFactory.getLogger(UserQualificationService.class);

    public UserAddressService(final UserProfileRepo userProfileRepo) {

        this.userProfileRepo = userProfileRepo;
    }


    @Override
    public List<UserProfileDto> getUserProfileElement(final String userId) throws InternalServerError {

        LOGGER.info("Fetching Exams info for user id : " + userId);

        final List<UserAddressDto> userAddressDtoList =
                userProfileDtoMapper.convertUserAddressListModelIntoDto(
                userProfileRepo.getUserAddress(userId));

        LOGGER.info(String.valueOf(userAddressDtoList));

        return new ArrayList<>(userAddressDtoList);
    }

    public void addUserProfileElement(final UserAddressDto userAddressDto,
                                      final String token) throws InternalServerError {

        final UserAddress userAddress =
                userProfileDtoMapper.convertUserAddressDtoIntoModel(userAddressDto);

        LOGGER.info("Adding or Updating userElement for id : " + userAddress.getUserId());

        if (0 == userAddress.getId()) {

            userAddress.setCreatedBy(jwtResolver.getIdFromJwtToken(token));
            userAddress.setCreatedDate(new Date(new java.util.Date().getTime()));
        }

        userAddress.setModifiedBy(jwtResolver.getIdFromJwtToken(token));
        userAddress.setModifiedDate(new Date(new java.util.Date().getTime()));

        userProfileRepo.addOrUpdateUserAddress(userAddress);
    }

    @Override
    public void deleteUserProfileElementById(final Long id) throws InternalServerError {

        userProfileRepo.deleteUserAddressById(id);
    }
}
