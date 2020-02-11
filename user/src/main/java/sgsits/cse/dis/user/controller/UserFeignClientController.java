package sgsits.cse.dis.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.user.message.request.SignUpForm;
import sgsits.cse.dis.user.message.response.ActiveStaffListResponse;
import sgsits.cse.dis.user.serviceImpl.UserServicesImpl;

@Api(value = "User Feign Client Controller")
@RestController
@RequestMapping(path = "/userFeignClientController")
public class UserFeignClientController {

	@Autowired
	private UserServicesImpl userServicesImpl;
	
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

}
