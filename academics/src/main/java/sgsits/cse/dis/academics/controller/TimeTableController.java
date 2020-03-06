package sgsits.cse.dis.academics.controller;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.academics.constants.RestAPI;
import sgsits.cse.dis.academics.exception.ConflictException;
import sgsits.cse.dis.academics.feignClient.InfrastuctureClient;
import sgsits.cse.dis.academics.jwt.JwtResolver;
import sgsits.cse.dis.academics.model.SemTimeTableSettings;
import sgsits.cse.dis.academics.request.FacultyTimeTableForm;
import sgsits.cse.dis.academics.response.FacultyNameListResponse;
import sgsits.cse.dis.academics.response.InfrastructureResponse;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.CoursesService;
import sgsits.cse.dis.academics.service.SchemeServices;
import sgsits.cse.dis.academics.service.SemTimeTableServices;
import sgsits.cse.dis.academics.service.SemesterTimeTableServices;
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
	private SemesterTimeTableServices semesterTimeTableServices;
	
	@Autowired
	private SemTimeTableServices semTimeTableServices;
	
	@Autowired
	private CoursesService coursesService;
	
	@Autowired
	private SchemeServices schemeServices;
	
	@Autowired
	private InfrastuctureClient infrastuctureClient;

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
	
	@ApiOperation(value="Get course name by course id",response=String.class,httpMethod = "GET")
	@GetMapping(path=RestAPI.GET_COURSE_NAME_BY_COURSE_ID, produces="text/plain")
	public ResponseEntity<String> getCourseNameByCourseId(@PathVariable("courseId") String courseId){
		return new ResponseEntity<String>(coursesService.getNameByCourseId(courseId),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get course id by  course name",response=String.class,httpMethod = "GET")
	@GetMapping(path=RestAPI.GET_COURSE_ID_BY_COURSE_NAME, produces="text/plain")
	public ResponseEntity<String> getCourseIdByCourseName(@PathVariable("courseName") String courseName){
		return new ResponseEntity<String>(coursesService.getCourseIdByName(courseName),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get course list", response = String.class, httpMethod = "GET")
	@GetMapping(value = RestAPI.GET_COURSE_LIST,produces = "application/json")
	public ResponseEntity<List<String>> getCourseList(){
		return new ResponseEntity<List<String>>( coursesService.getCourseList(),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get course list", response = String.class, httpMethod = "GET")
	@GetMapping(value = RestAPI.GET_SUBJECT_CODES_LIST_BY_YEAR_AND_SEMESTER,produces = "application/json")
	public ResponseEntity<List<String>> getSubjectCodesListByYearAndSemster(@PathVariable("year") String year,@PathVariable("sem") String sem,@PathVariable("course") String course){
		return new ResponseEntity<List<String>>( schemeServices.getSubjectCodesByYearAndSemesterAndCourse(year, sem, course),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Infrastructure by type", response = InfrastructureResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_INFRASTRUCTURE_BY_TYPE, produces = "application/json")
	public ResponseEntity<List<InfrastructureResponse>> getInfrastructureByType(@PathVariable("type") String type){
		return new ResponseEntity<List<InfrastructureResponse>>(infrastuctureClient.getInfrastructureByType(type),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add semester time table", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path = RestAPI.ADD_SEMESTER_TIME_TABLE, produces = "application/json")
	public ResponseEntity<ResponseMessage> addSemTimeTable(@RequestBody FacultyTimeTableForm facultyTimeTableForm,HttpServletRequest request) throws ConflictException{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(semesterTimeTableServices.addTimeTable(facultyTimeTableForm, 
				jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")))) 
				,HttpStatus.OK);
	}
	
	@ApiOperation(value="Get subject code by faculty id and session", response = String.class, httpMethod = "GET")
	@GetMapping(value = RestAPI.GET_SUBJECT_CODES_BY_FACULTY_ID_AND_SESSION,produces = "application/json")
	public ResponseEntity<List<String>> getSubjectCodesByFacultyIdAndSession(@PathVariable("facultyId")String facultyId,@PathVariable("session") String session){
		return new ResponseEntity<List<String>>( semesterTimeTableServices.getSubjectCodesByFacultyIdAndSession(facultyId, session),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get time table by Faculty id, session and subject code", response = FacultyTimeTableForm.class, httpMethod = "GET")
	@GetMapping(value = RestAPI.GET_TIMETABLE_BY_FACULTY_ID_SESSION_AND_SUBJECT_CODE,produces = "application/json")
	public ResponseEntity<FacultyTimeTableForm> getTimeTableByFacultyIdSessionAndSubjectCode(@PathVariable("facultyId")String facultyId,
			@PathVariable("session") String session,@PathVariable("subjectCode") String subjectCode) throws NotFoundException{
		return new ResponseEntity<FacultyTimeTableForm>( semesterTimeTableServices.getTimeTableByFacultyIdAndSessionAndSubjectCode(facultyId, session, subjectCode),HttpStatus.OK);
	}

}
