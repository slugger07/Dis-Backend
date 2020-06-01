package sgsits.cse.dis.user.service;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.dtos.*;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.exception.UnauthorizedException;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.mappers.UserProfileDtoMapper;
import sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl.UserQualificationService;

import java.util.List;

@Component
public interface UserProfileService {

    JwtResolver jwtResolver = new JwtResolver();
    UserProfileDtoMapper userProfileDtoMapper = Mappers.getMapper(UserProfileDtoMapper.class);
    Logger LOGGER = LoggerFactory.getLogger(UserQualificationService.class);


    List<UserProfileDto> getUserProfileElement(final String token) throws InternalServerError;
    void deleteUserProfileElementById(final Long id, final String userId) throws InternalServerError, UnauthorizedException;
}
