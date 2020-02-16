package sgsits.cse.dis.administration.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.administration.constants.RestAPI;
import sgsits.cse.dis.administration.exception.ConflictException;
import sgsits.cse.dis.administration.request.FacultyResourceRequestForm;
//import sgsits.cse.dis.administration.response.FacultyResourceRequestResponse;
import sgsits.cse.dis.administration.response.ResponseMessage;
import sgsits.cse.dis.administration.service.ResourceRequestServices;
import sgsits.cse.dis.administration.jwt.JwtResolver;

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
}
