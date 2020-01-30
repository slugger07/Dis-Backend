package sgsits.cse.dis.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.user.constants.RestAPI;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.message.request.AddNewUser;
import sgsits.cse.dis.user.message.response.FacultyData;
import sgsits.cse.dis.user.serviceImpl.StaffServiceImpl;

@CrossOrigin(origins = "*")
@Api(value = "Staff controller")
@RestController
@RequestMapping(path = "/staffProfile")
public class StaffController {
	
	private JwtResolver jwtResolver = new JwtResolver();
	
	@Autowired
	private StaffServiceImpl staffServiceImpl;
	
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
	
	@ApiOperation(value = "add new member", response = Object.class, httpMethod = "POST", produces = "text/plain")
	@PostMapping(value = RestAPI.ADD_NEW_MEMBER, produces = "text/plain")
	public ResponseEntity<String> addNewStaff(@RequestBody AddNewUser addNewUser,HttpServletRequest request) throws ConflictException {
		return new ResponseEntity<String>(staffServiceImpl.addNewMember(addNewUser, jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"))),HttpStatus.OK);
	}
}
