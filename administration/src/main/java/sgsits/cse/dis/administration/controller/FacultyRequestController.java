package sgsits.cse.dis.administration.controller;

import java.util.List;

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
import sgsits.cse.dis.administration.request.FacultyRequestEditForm;
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
	public FacultyRequest getFacultyRequest(@PathVariable String id, HttpServletRequest request) {
		return facultyRequestService.getRequest(id, request);
	}
	
	@ApiOperation(value = "Edit Faculty Resource Request", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = RestAPI.EDIT_FACULTY_RESOURCE_REQUEST, method = RequestMethod.PUT) 
	public ResponseEntity<?> editFacultyRequest(@PathVariable("id") String requestId, @RequestBody FacultyRequestEditForm facultyRequestEditForm, HttpServletRequest request) {
		FacultyRequest resourceRequest = facultyRequestService.updateRequest(requestId, facultyRequestEditForm, request);
		if (resourceRequest != null) {
			return new ResponseEntity<>(new ResponseMessage(FacultyRequestConstants.EDIT_RESOURCE_REQUEST_SUCESS), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseMessage(FacultyRequestConstants.EDIT_RESOURCE_REQUEST_BAD), HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "Get all requests for an ID", response = FacultyRequest.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_ALL_FACULTY_REQUESTS_FOR_ID, method = RequestMethod.GET) 
	public List<FacultyRequest> getAllFacultyRequestsForId(HttpServletRequest request) {
		return facultyRequestService.getUnresolvedRequestsById(request);
	}
	
	@ApiOperation(value = "Get all resolved requests", response = FacultyRequest.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_ALL_FACULTY_REQUESTS_RESOLVED, method = RequestMethod.GET)
	public List<FacultyRequest> getAllResolvedFacultyRequests(HttpServletRequest request) {
		return facultyRequestService.getAllResolvedRequests(request);
	}
	
	@ApiOperation(value = "Get all unresolved requests", response = FacultyRequest.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_ALL_FACULTY_REQUESTS_UNRESOLVED, method = RequestMethod.GET)
	public List<FacultyRequest> getAllUnrelsovedFacultyRequests(HttpServletRequest request) {
		return facultyRequestService.getAllUnresolvedRequests(request);
	}
	
	@RequestMapping(value = RestAPI.SET_FACULTY_REQUEST_RESOLVED, method = RequestMethod.PUT)
	public ResponseEntity<?> editToResolved(@PathVariable("id") String requestId, HttpServletRequest request) {
		FacultyRequest resourceRequest = facultyRequestService.setResolved(requestId, request);
		if (resourceRequest != null) {
			return new ResponseEntity<>(new ResponseMessage(FacultyRequestConstants.SET_STATUS_RESOLVED_SUCCESS), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseMessage(FacultyRequestConstants.SET_STATUS_RESOLVED_BAD), HttpStatus.BAD_REQUEST);
	}
	
}
