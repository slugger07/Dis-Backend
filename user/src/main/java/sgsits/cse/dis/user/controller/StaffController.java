package sgsits.cse.dis.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.user.constants.RestAPI;
import sgsits.cse.dis.user.dtos.FacultyDataDto;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.message.request.AddNewUser;
import sgsits.cse.dis.user.message.response.FacultyData;
import sgsits.cse.dis.user.message.response.ResponseMessage;
import sgsits.cse.dis.user.service.StaffService;

@CrossOrigin(origins = "*")
@Api(value = "Staff controller")
@RestController
@RequestMapping(path = "/staffProfile")
public class StaffController {

	private final JwtResolver jwtResolver = new JwtResolver();

	private final StaffService staffServiceImpl;

	@Autowired
	public StaffController(final StaffService staffServiceImpl) {
		this.staffServiceImpl = staffServiceImpl;
	}

	@ApiOperation(value = "Staff Data", response = Object.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_STAFF_DATA, produces = "application/json")
	public ResponseEntity<List<FacultyDataDto>> getStaffData() {

		return new ResponseEntity<>(staffServiceImpl.getStaffData(), HttpStatus.OK);
	}

	@ApiOperation(value = "Faculty Data", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_FACULTY_DATA, produces = "application/json")
	public ResponseEntity<List<FacultyDataDto>> getFacultyData() {

		return new ResponseEntity<>(staffServiceImpl.getFacultyData(), HttpStatus.OK);
	}

	@ApiOperation(value = "add new member", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(value = RestAPI.ADD_NEW_MEMBER, produces = "application/json")
	public ResponseEntity<ResponseMessage> addNewStaff(@RequestBody final AddNewUser addNewUser,
			final HttpServletRequest request) throws ConflictException {

		return new ResponseEntity<>(new ResponseMessage(staffServiceImpl.addNewMember(addNewUser,
				jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")))), HttpStatus.OK);
	}

	@ApiOperation(value = "Find Staff with name", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_STAFF_WITH_NAME, produces = "application/json")
	public ResponseEntity<List<FacultyDataDto>> getStaffWithName(@PathVariable("name") final String name) {

		return new ResponseEntity<>(staffServiceImpl.getStaffWithName(name), HttpStatus.OK);
	}

	@ApiOperation(value = "get list of all employees", response = ResponseMessage.class, httpMethod = "GET", produces = "text/plain")
	@GetMapping(path = RestAPI.GET_ALL_USER_ID_AND_NAMES, produces = "application/json")
	public ResponseEntity<List<Object[]>> getAllUserIdAndNames() throws NotFoundException {

		return new ResponseEntity<>(staffServiceImpl.getAllEmployeeNamesAndUserId(), HttpStatus.OK);
	}
	
	@ApiOperation(value="get active staff list", response = ResponseMessage.class, httpMethod = "GET", produces = "text/plain")
	@GetMapping(path=RestAPI.GET_MY_USER_ID, produces = "application/json")
	public ResponseEntity<ResponseMessage> getMyUserId(HttpServletRequest request) throws NotFoundException{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"))),HttpStatus.OK);
	}
}
