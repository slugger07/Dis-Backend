package sgsits.cse.dis.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jdk.nashorn.internal.codegen.ObjectCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.user.constants.RestAPI;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.message.request.AddNewUser;
import sgsits.cse.dis.user.message.response.FacultyData;
import sgsits.cse.dis.user.message.response.ResponseMessage;
import sgsits.cse.dis.user.service.StaffService;

/**
 * <h1>StaffController</h1> class.
 * <p>This controller exposes staff services as REST end points at default path <b>/staffProfile</b>.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 27-JAN-2020.
 * @throws ConflictException.
 * @throws NotFoundException.
 * @throws EventDoesNotExistException.
 * @throws DataIntegrityViolationException
 * @throws MethodArgumentNotValidException
 * @see NotFoundException.
 * @see DataIntegrityViolationException
 * @see MethodArgumentNotValidException
 */
@CrossOrigin(origins = "*")
@Api(value = "Staff controller")
@RestController
@RequestMapping(path = "/staffProfile")
public class StaffController {
	
	private JwtResolver jwtResolver = new JwtResolver();
	
	@Autowired
	private StaffService staffServiceImpl;
	
	@ApiOperation(value = "Staff Data", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_STAFF_DATA, produces = "application/json")
	public ResponseEntity<List<FacultyData>> getStaffData() {
		return new ResponseEntity<List<FacultyData>>(staffServiceImpl.getStaffData(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Faculty Data", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_FACULTY_DATA, produces = "application/json")
	public ResponseEntity<List<FacultyData>> getFacultyData() {
		return new ResponseEntity<List<FacultyData>>(staffServiceImpl.getFacultyData(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "add new member", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(value = RestAPI.ADD_NEW_MEMBER, produces = "application/json")
	public ResponseEntity<ResponseMessage> addNewStaff(@RequestBody AddNewUser addNewUser,HttpServletRequest request) throws ConflictException {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(staffServiceImpl.addNewMember(addNewUser, jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")))),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Find Staff with name", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_STAFF_WITH_NAME, produces = "application/json")
	public ResponseEntity<List<FacultyData>> getStaffWithName(@PathVariable("name") String name) {
		return new ResponseEntity<List<FacultyData>>(staffServiceImpl.getStaffWithName(name),HttpStatus.OK);
	}
	@ApiOperation(value="get active staff list", response = ResponseMessage.class, httpMethod = "GET", produces = "text/plain")
	@GetMapping(path=RestAPI.GET_MY_USER_ID, produces = "application/json")
	public ResponseEntity<ResponseMessage> getMyUserId(HttpServletRequest request) throws NotFoundException{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"))),HttpStatus.OK);
	}

	@ApiOperation(value="get list of all employees", response = ResponseMessage.class, httpMethod = "GET", produces = "text/plain")
	@GetMapping(path=RestAPI.GET_ALL_USER_ID_AND_NAMES, produces = "application/json")
	public ResponseEntity<List<Object[]>> getAllUserIdAndNames(HttpServletRequest request) throws NotFoundException{
		return new ResponseEntity<List<Object[]>>(staffServiceImpl.getAllEmployeeNamesAndUserId(),HttpStatus.OK);
	}

	// internal requirement for calender api
	public List<Object[]> getAllUsernameAndEmails() {
		return staffServiceImpl.getAllUsernameAndEmail();
	}
}
