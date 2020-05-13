package sgsits.cse.dis.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sgsits.cse.dis.user.constants.ControllerConstants;
import sgsits.cse.dis.user.dtos.*;
import sgsits.cse.dis.user.serviceImpl.userProfileServiceImpl.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*")
@Api(value = "UserProfile controller")
@RestController
public class UserProfileController {

    private final UserWorkExperienceService userWorkExperienceService;
    private final UserResearchWorkService userResearchWorkService;
    private final UserCompetitiveExamService userCompetitiveExamService;
    private final UserCulturalActivityAchievementService userCulturalActivityAchievementService;
    private final UserInternshipService userInternshipService;
    private final UserProjectService userProjectService;
    private final UserQualificationService userQualificationService;
    private final UserTechnicalActivityService userTechnicalActivityService;


    @Autowired
    public UserProfileController(final UserWorkExperienceService userWorkExperienceService,
                                 final UserResearchWorkService userResearchWorkService,
                                 final UserCompetitiveExamService userCompetitiveExamService,
                                 final UserCulturalActivityAchievementService userCulturalActivityAchievementService,
                                 final UserInternshipService userInternshipService,
                                 final UserProjectService userProjectService,
                                 final UserQualificationService userQualificationService,
                                 final UserTechnicalActivityService userTechnicalActivityService) {
        this.userWorkExperienceService = userWorkExperienceService;
        this.userResearchWorkService = userResearchWorkService;
        this.userCompetitiveExamService = userCompetitiveExamService;
        this.userCulturalActivityAchievementService = userCulturalActivityAchievementService;
        this.userInternshipService = userInternshipService;
        this.userProjectService = userProjectService;
        this.userQualificationService = userQualificationService;
        this.userTechnicalActivityService = userTechnicalActivityService;
    }

    @ApiOperation(value = "Faculty Brief Data", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/facultyBrief")
    public List<FacultyBriefDataDto> getFacultyBriefData() {
       return null;
    }

    @ApiOperation(value = "Staff Brief Data", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/staffBrief")
    public List<FacultyBriefDataDto> getStaffBriefData() {
        return null;
    }

    @ApiOperation(value = "Faculty Data", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/facultyData")
    public List<FacultyDataDto> getFacultyData(){
        return null;
    }

    @ApiOperation(value = "Staff Data", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/staffData")
    public List<FacultyDataDto> getStaffData() {
        return null;
    }

    @ApiOperation(value = "User Qualification", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/userQualification")
    public ResponseEntity<List<UserProfileDto>> getUserQualification(HttpServletRequest request) {
        return new ResponseEntity<>(userQualificationService.getUserProfileElement(
                request.getHeader(ControllerConstants.AUTHORIZATION)), HttpStatus.OK);
    }

    @ApiOperation(value = "User Work Experience", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/userWorkExperience")
    public ResponseEntity<List<UserProfileDto>> getUserWorkExperience(HttpServletRequest request) {
        return new ResponseEntity<>(userWorkExperienceService.getUserProfileElement(
                request.getHeader(ControllerConstants.AUTHORIZATION)), HttpStatus.OK);
    }

    @ApiOperation(value = "User Research Work", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/userResearchWork")
    public ResponseEntity<List<UserProfileDto>> getUserResearchWork(HttpServletRequest request) {
        return new ResponseEntity<>(userResearchWorkService.getUserProfileElement(
                request.getHeader(ControllerConstants.AUTHORIZATION)), HttpStatus.OK);
    }

    @ApiOperation(value = "User Internship", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/userInternship")
    public ResponseEntity<List<UserProfileDto>> getUserInternship(HttpServletRequest request) {
        return new ResponseEntity<>(userInternshipService.getUserProfileElement(
                request.getHeader(ControllerConstants.AUTHORIZATION)), HttpStatus.OK);
    }

    @ApiOperation(value = "User Technical Activity", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/userTechnicalActivity")
    public ResponseEntity<List<UserProfileDto>> getUserTechnicalActivity(HttpServletRequest request) {
      return new ResponseEntity<>(userTechnicalActivityService.getUserProfileElement(
              request.getHeader(ControllerConstants.AUTHORIZATION)), HttpStatus.OK);
    }

    @ApiOperation(value = "User Cultural Activity Achievements", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/userCulturalActivityAchievements")
    public ResponseEntity<List<UserProfileDto>> getUserCulturalActivityAchievements(HttpServletRequest request) {
       return new ResponseEntity<>(userCulturalActivityAchievementService.getUserProfileElement(
               request.getHeader(ControllerConstants.AUTHORIZATION)), HttpStatus.OK);
    }

    @ApiOperation(value = "User Competitive Exams", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/userCompetitiveExams")
    public ResponseEntity<List<UserProfileDto>> getUserCompetitiveExams(HttpServletRequest request) {
        return new ResponseEntity<>(userCompetitiveExamService.getUserProfileElement(
                request.getHeader(ControllerConstants.AUTHORIZATION)), HttpStatus.OK);
    }

    @ApiOperation(value = "User Project", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/userProject")
    public ResponseEntity<List<UserProfileDto>> getUserProject(HttpServletRequest request) {
        return new ResponseEntity<>(userProjectService.getUserProfileElement(
                request.getHeader(ControllerConstants.AUTHORIZATION)), HttpStatus.OK);
    }

    @ApiOperation(value = "Staff Basic Profile Data", response = Object.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/staffBasicProfile")
    public StaffBasicProfileDto getStaffBasicProfile(HttpServletRequest request) {
       return null;
    }

    public List<StaffDutyDto> getStaffDuties(HttpServletRequest request) {
        return null;
    }

    public void getStudentBasicProfile(HttpServletRequest request) {

    }

    public void getStudentPlacement(HttpServletRequest request) {

    }

    public void getUGProject(HttpServletRequest request) {

    }

    public void getPGProject(HttpServletRequest request) {

    }

}
