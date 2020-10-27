package sgsits.cse.dis.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.user.constants.ControllerConstants;
import sgsits.cse.dis.user.dtos.ProfilePictureDto;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.exception.NotFoundException;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.message.response.ResponseMessage;
import sgsits.cse.dis.user.serviceImpl.ProfilePictureService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@CrossOrigin(origins = "*")
@Api(value = "User Profile Picture controller")
@RestController
public class UserProfilePictureController {

    private final ProfilePictureService profilePictureService;

    private final JwtResolver jwtResolver = new JwtResolver();

    public UserProfilePictureController(final ProfilePictureService profilePictureService) {
        this.profilePictureService = profilePictureService;
    }

    @ApiOperation(value = "Profile Picture", response = Object.class, httpMethod = "POST", produces = "application/json")
    @PostMapping(value = "/updateProfilePicture")
    public ResponseEntity<ResponseMessage> uploadProfilePicture(
            @RequestParam("imageFile") MultipartFile imageFile, HttpServletRequest request)
            throws IOException, InternalServerError {

        System.out.println("Original Image Byte Size - " + imageFile.getBytes().length);

        profilePictureService.addOrUpdateProfilePicture(imageFile,
                request.getHeader(ControllerConstants.AUTHORIZATION));

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(
                "Profile Picture Successfully uploaded"));
    }


    @ApiOperation(value = "Get Profile Picture", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/getProfilePicture")
    public ResponseEntity<ProfilePictureDto> getProfilePicture(
            HttpServletRequest request, @RequestParam String userId) throws
            InternalServerError, NotFoundException {

        final String id = StringUtils.isBlank(userId) ?
                jwtResolver.getIdFromJwtToken(request.getHeader(ControllerConstants.AUTHORIZATION)) : userId;

        return new ResponseEntity<>(profilePictureService.getUserProfilePicture(
                id, 1), HttpStatus.OK);
    }

}
