package sgsits.cse.dis.user.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.user.dtos.FacultyDataDto;
import sgsits.cse.dis.user.message.request.SignUpForm;
import sgsits.cse.dis.user.message.response.ActiveStaffListResponse;
import sgsits.cse.dis.user.message.response.FacultyData;
import sgsits.cse.dis.user.repo.StaffBasicProfileRepository;
import sgsits.cse.dis.user.service.StaffService;
import sgsits.cse.dis.user.service.UserServices;

@Api(value = "User Feign Client Controller")
@RestController
@RequestMapping(path = "/userFeignClientController")
public class UserFeignClientController {

    private final UserServices userServicesImpl;

    private final StaffService staffService;

    private final StaffBasicProfileRepository staffBasicProfileRepository;

    public UserFeignClientController(final UserServices userServicesImpl, final StaffService staffService,
            final StaffBasicProfileRepository staffBasicProfileRepository) {

        this.userServicesImpl = userServicesImpl;
        this.staffService = staffService;
        this.staffBasicProfileRepository = staffBasicProfileRepository;
    }

    @ApiOperation(value = "get ID for given username", response = String.class, httpMethod = "GET", produces = "application/json")
    @RequestMapping(value = "/getUserId", method = RequestMethod.GET)
    public String getUserId(@RequestParam("username") String username) {
        return userServicesImpl.getUserId(username);
    }

    @ApiOperation(value = "Verify username", response = boolean.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/existsByUsername/{username}")
    public boolean existsByUsername(@PathVariable("username") String username) throws NotFoundException {
        return userServicesImpl.existsByUsername(username);
    }

    @ApiOperation(value = "Find User", response = Boolean.class, httpMethod = "POST", produces = "text/plain")
    @PostMapping(value = "/findUser")
    public boolean findUser(@RequestBody SignUpForm signup) {

        return userServicesImpl.findUser(signup);
    }

    @ApiOperation(value = "Find User Type", response = Boolean.class, httpMethod = "POST", produces = "text/plain")
    @PostMapping(value = "/findUserIype")
    public String findUserType(@RequestBody SignUpForm signup) {

        return userServicesImpl.findUserType(signup);
    }

    @ApiOperation(value = "Update email and user Id", response = Boolean.class, httpMethod = "GET", produces = "text/plain")
    @GetMapping(value = "/updateEmailAndUserId")
    public boolean updateEmailAndUserId(@RequestParam("mobileNo") long mobileNo) {

        return userServicesImpl.updateEmailAndUserId(mobileNo);
    }

    @ApiOperation(value = "Get active staff list", response = boolean.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/getActiveStaffList")
    public ResponseEntity<List<ActiveStaffListResponse>> activeStaffListResponse() throws NotFoundException {

        return new ResponseEntity<>(userServicesImpl.getActiveStaffList(), HttpStatus.OK);
    }

    @ApiOperation(value = "Staff name list", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/getStaffNameList", produces = "application/json")
    public ResponseEntity<List<FacultyDataDto>> getStaffData() {

        return new ResponseEntity<>(staffService.getStaffData(), HttpStatus.OK);
    }

    @ApiOperation(value = "Faculty name list", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
    @GetMapping(value = "/getFacultyNameList", produces = "application/json")
    public ResponseEntity<List<FacultyDataDto>> getFacultyData() {

        return new ResponseEntity<>(staffService.getFacultyData(), HttpStatus.OK);
    }
    
	@ApiOperation(value = "get user name by id optional", response = String.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getUserNameByIdOptional", method = RequestMethod.POST)
	public ResponseEntity<String> getUserNameByIdOptinal(@RequestBody Optional<String> userId){
		return  new ResponseEntity<String>(staffService.getNameByIdOptional(userId),HttpStatus.OK);
	}

    @ApiOperation(value = "get user name by id", response = String.class, httpMethod = "GET", produces = "application/json")
    @RequestMapping(value = "/getUserNameById/{userId}")
    public ResponseEntity<String> getUserNameById(@PathVariable String userId) {
        return new ResponseEntity<>(staffService.getNameById(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "Update user id with email", response = String.class, httpMethod = "PUT", produces = "application/json")
    @PutMapping(value = "/updateUserIdWithEmail/{userId}/{email}", produces = "application/jspn")
    @Transactional
    public ResponseEntity<String> updateUserIdByEmail(@PathVariable("userId") String userId,
            @PathVariable("email") String email) {

        staffBasicProfileRepository.updateUserIdByEmailId(userId, email);
        return new ResponseEntity<>(userId + " assigned to user with email " + email, HttpStatus.OK);
    }

}
