package sgsits.cse.dis.administration.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.administration.constants.FacultyRequestConstants;
import sgsits.cse.dis.administration.constants.RestAPI;
import sgsits.cse.dis.administration.jwt.JwtResolver;
import sgsits.cse.dis.administration.model.FacultyRequest;
import sgsits.cse.dis.administration.request.FacultyRequestForm;
import sgsits.cse.dis.administration.response.ResponseMessage;
import sgsits.cse.dis.administration.service.FacultyRequestService;

@CrossOrigin(origins = "*")
@Api(value = "methods pertaining to resource requests from faculties")
@RestController
public class FacultyRequestController {
	
	@Autowired
	FacultyRequestService facultyRequestService;
	
	JwtResolver jwtResolver = new JwtResolver();
	
	@ApiOperation(value = "Add Faculty Resource Request", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = RestAPI.ADD_FACULTY_RESOURCE_REQUEST, method = RequestMethod.POST)
	public ResponseEntity<?> addFacultyRequest(@RequestBody FacultyRequestForm facultyRequestForm, HttpServletRequest request) {
		FacultyRequest resourceRequest = facultyRequestService.addRequest(facultyRequestForm, request);
		if (resourceRequest != null) {
			return new ResponseEntity<>(new ResponseMessage(FacultyRequestConstants.ADD_RESOURCE_REQUEST_SUCESS), HttpStatus.CREATED);
		} 
		return new ResponseEntity<>(new ResponseMessage(FacultyRequestConstants.ADD_RESOURCE_REQUEST_BAD),
				HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "Get Faculty Resource Request", response = FacultyRequest.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_FACULTY_RESOURCE_REQUEST, method = RequestMethod.GET) 
	public Optional<FacultyRequest> getFacultyRequest(@PathVariable String id, HttpServletRequest request) {
		return facultyRequestService.getRequest(id, request);
	}
	
//	@RequestMapping(value = RestAPI.EDIT_FACULTY_RESOURCE_REQUEST, method = RequestMethod.PUT) 
//	public ResponseEntity<?> editFacultyRequest()
}
