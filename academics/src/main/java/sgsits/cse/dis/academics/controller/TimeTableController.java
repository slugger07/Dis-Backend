package sgsits.cse.dis.academics.controller;

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
import sgsits.cse.dis.academics.constants.RestAPI;
import sgsits.cse.dis.academics.exception.ConflictException;
import sgsits.cse.dis.academics.jwt.JwtResolver;
import sgsits.cse.dis.academics.model.SemTimeTableSettings;
import sgsits.cse.dis.academics.response.FacultyNameListResponse;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.SemTimeTableServices;
import sgsits.cse.dis.academics.service.TimeTableSettingServices;

/**
 * <h1>TimeTableController.</h1>
 * <p>This controller exposes TimeTable services as REST end points at default path <b>/timeTable</b>.
 * These services are meant to be consumed only by feignClient in any other microservice.
 * @author Arjit Mishra,.
 * @version 1.0.
 * @since 25-FEB-2020.
 */
@CrossOrigin(origins = "*")
@Api(value = "Time Table Controller")
@RestController
@RequestMapping(path = "/timeTable")
public class TimeTableController {
	
	
	private JwtResolver jwtResolver = new JwtResolver();
	
	@Autowired
	private TimeTableSettingServices timeTableSettingServices;
	
	@Autowired
	private SemTimeTableServices semTimeTableServices;

	@ApiOperation(value = "Get semester time table settings", response = SemTimeTableSettings.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_SEM_TIME_TABLE_SETTINGS, produces = "application/json")
	public ResponseEntity<SemTimeTableSettings> getSemTimeTableSettings() {
		return new ResponseEntity<SemTimeTableSettings>(timeTableSettingServices.getSemTimeTableSettings(),
				HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get semester time table settings", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path = RestAPI.SAVE_SEM_TIME_TABLE_SETTINGS, produces = "application/json")
	public ResponseEntity<ResponseMessage> saveSemTimeTableSettings(@RequestBody SemTimeTableSettings semTimeTableSettings,HttpServletRequest request) throws ConflictException {
		timeTableSettingServices.saveSemTimeTableSettings(semTimeTableSettings,
				jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")));
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Settings updated!!!"),
				HttpStatus.OK);
	}
	
	@ApiOperation(value="Get Faculty name list",response=FacultyNameListResponse.class,httpMethod = "GET")
	@GetMapping(path=RestAPI.GET_FACULTY_NAME_LIST, produces="application/json")
	public ResponseEntity<List<FacultyNameListResponse>> getFacultyNameList(){
		return new ResponseEntity<List<FacultyNameListResponse>>(semTimeTableServices.getFacultyNameList(),HttpStatus.OK);
	}

}
