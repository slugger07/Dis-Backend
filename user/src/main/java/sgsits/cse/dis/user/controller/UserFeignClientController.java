package sgsits.cse.dis.user.controller;

/**
 * <h1>UserFeignController.</h1>
 * <p>This controller exposes user services as REST end points at default path <b>/userFeignCliemntController</b>.
 * These servies are meant to be consumed only by feignClient in any other microservice.
 * @author Arjit Mishra,Devyani garg.
 * @version 1.0.
 * @since 2-DEC-2019.
 */

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.user.constants.RestAPI;
import sgsits.cse.dis.user.message.request.SignUpForm;
import sgsits.cse.dis.user.message.response.ActiveStaffListResponse;
import sgsits.cse.dis.user.message.response.FacultyData;
import sgsits.cse.dis.user.model.StaffProfile;
import sgsits.cse.dis.user.repo.StaffRepository;
import sgsits.cse.dis.user.service.StaffService;
import sgsits.cse.dis.user.service.UserServices;
import sgsits.cse.dis.user.serviceImpl.StaffServiceImpl;
import sgsits.cse.dis.user.serviceImpl.UserServicesImpl;

@Api(value = "User Feign Client Controller")
@RestController
@RequestMapping(path = "/userFeignClientController")
public class UserFeignClientController {

	@Autowired
	private UserServices userServicesImpl;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@ApiOperation(value="Verify username", response = boolean.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/existsByUsername/{username}")
	public boolean existsByUsername(@PathVariable("username") String username) throws NotFoundException {
		return userServicesImpl.existsByUsername(username);
	}

    @ApiOperation(value = "Find User", response = Boolean.class, httpMethod = "POST", produces = "text/plain")
    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    public boolean findUser(@RequestBody SignUpForm signup)
    {
        return userServicesImpl.findUser(signup);
    }

    @ApiOperation(value = "Find User Type", response = Boolean.class, httpMethod = "POST", produces = "text/plain")
    @RequestMapping(value = "/findUserIype", method = RequestMethod.POST)
    public String findUserType(@RequestBody SignUpForm signup)
    {
        return userServicesImpl.findUserType(signup);
    }

    @ApiOperation(value = "Update email and user Id", response = Boolean.class, httpMethod = "GET", produces = "text/plain")
    @RequestMapping(value = "/updateEmailAndUserId", method = RequestMethod.GET)
    public boolean updateEmailAndUserId(@RequestParam("mobileNo") long mobileNo)
    {
        return userServicesImpl.updateEmailAndUserId(mobileNo);
    }
    
	@ApiOperation(value="Get active staff list", response = boolean.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/getActiveStaffList")
	public ResponseEntity<List<ActiveStaffListResponse>> activeStaffListResponse() throws NotFoundException{
		return new ResponseEntity<List<ActiveStaffListResponse>>(userServicesImpl.getActiveStaffList(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Staff name list", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/getStaffNameList", produces = "application/json")
	public ResponseEntity<List<FacultyData>> getStaffData() {
		return new ResponseEntity<List<FacultyData>>(staffService.getStaffData(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Faculty name list", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/getFacultyNameList", produces = "application/json")
	public ResponseEntity<List<FacultyData>> getFacultyData() {
		return new ResponseEntity<List<FacultyData>>(staffService.getFacultyData(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "get user name by id", response = String.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getUserNameById/{userId}", method = RequestMethod.GET)
	public ResponseEntity<String> getUserNameById(@PathVariable String userId){
		return  new ResponseEntity<String>(staffService.getNameById(userId),HttpStatus.OK);
	}
	
	@ApiOperation(value = "get user name by id", response = String.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getUserNameByIdOptional", method = RequestMethod.POST)
	public ResponseEntity<String> getUserNameByIdOptinal(@RequestBody Optional<String> userId){
		return  new ResponseEntity<String>(staffService.getNameByIdOptional(userId),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update user id with email", response = String.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(value = "/updateUserIdWithEmail/{userId}/{email}", produces = "application/jspn")
	@Transactional
	public ResponseEntity<String> updateUserIdByEmail(@PathVariable("userId") String userId,@PathVariable("email") String email){
		staffRepository.updateUserIdByEmailId(userId, email);
		return  new ResponseEntity<String>(new String(userId+" assigned to user with email "+email),HttpStatus.OK);
	}
	

}
