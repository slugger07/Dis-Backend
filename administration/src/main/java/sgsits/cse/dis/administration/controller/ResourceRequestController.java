package sgsits.cse.dis.administration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.administration.constants.RestAPI;
import sgsits.cse.dis.administration.exception.ConflictException;
import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.request.FacultyResourceRequestForm;
//import sgsits.cse.dis.administration.response.FacultyResourceRequestResponse;
import sgsits.cse.dis.administration.response.ResponseMessage;
import sgsits.cse.dis.administration.service.ResourceRequestServices;
import sgsits.cse.dis.administration.jwt.JwtResolver;
import sgsits.cse.dis.administration.model.FacultyResourceRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/resourceRequest")
@Api(value = "Resource Request")
public class ResourceRequestController {
	
	private JwtResolver jwtResolver = new JwtResolver();
	
	@Autowired
	private ResourceRequestServices resourceRequestServices;
	
	@ApiOperation(value="Add Faculty Resource Request", response=String.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path=RestAPI.ADD_FACULTY_RESOURCE_REQUEST, produces = "application/json")
	public ResponseEntity<ResponseMessage> addFacultyResourceRequest (@RequestBody FacultyResourceRequestForm facultyResourceRequestForm,HttpServletRequest request) throws ConflictException
	{
		
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(
				resourceRequestServices.addFacultyResourceRequest(facultyResourceRequestForm, jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")))),
				HttpStatus.OK);
	}
	
	@ApiOperation(value="Show Faculty Resrouce Request", response=FacultyResourceRequest.class, httpMethod="GET", produces="application/json")
	@GetMapping(path=RestAPI.SHOW_FACULTY_RESOURCE_REQUEST, produces="application/json")
	public ResponseEntity<List<FacultyResourceRequest>> showFacultyResourceRequest (@PathVariable("status") String status) throws EventDoesNotExistException
	{
		return new ResponseEntity<List<FacultyResourceRequest>> (resourceRequestServices.showFacultyResourceRequest(status) , HttpStatus.OK);
	}
	
	@ApiOperation(value="Search Faculty Resource Request By Priority", response=FacultyResourceRequest.class, httpMethod="GET", produces="application/json")
	@GetMapping(path=RestAPI.SEARCH_FACULTY_RESOURCE_REQUEST_BY_PRIORITY, produces="application/json")
	public ResponseEntity<List<FacultyResourceRequest>> searchFacultyResourceRequestByPriority (@PathVariable("priority") String priority) throws EventDoesNotExistException
	{
		return new ResponseEntity<List<FacultyResourceRequest>> (resourceRequestServices.searchFacultyResourceRequestByPriority(priority) , HttpStatus.OK);
	}
	
}
