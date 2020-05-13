package sgsits.cse.dis.user.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.dtos.*;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.mappers.UserProfileDtoMapper;

import java.util.List;

@Component
public interface UserProfileService {

    JwtResolver jwtResolver = new JwtResolver();
    UserProfileDtoMapper userProfileDtoMapper = Mappers.getMapper(UserProfileDtoMapper.class);

    List<UserProfileDto> getUserProfileElement(final String token);
    void deleteUserProfileElementById(Long id);
}
