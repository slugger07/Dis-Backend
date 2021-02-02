package sgsits.cse.dis.academics.controller;

/**
 * <h1>AcademicsFeignController.</h1>
 * <p>This controller exposes academics services as REST end points at default path <b>/academicsFeignCliemntController</b>.
 * These services are meant to be consumed only by feignClient in any other microservice.
 * @author Arjit Mishra,Devyani garg.
 * @version 1.0.
 * @since 2-DEC-2019.
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.academics.service.CoursesService;
import sgsits.cse.dis.academics.serviceImpl.CoursesServiceImpl;
import sgsits.cse.dis.academics.serviceImpl.SchemeServiceImpl;

@Api(value = "Academics Feign Client Controller")
@RestController
@RequestMapping(path = "/academicsFeignClientController")
public class AcademicsFeignClientController {
	
	@Autowired
	private SchemeServiceImpl schemeServiceImpl;
	
	@Autowired
	private CoursesService coursesServiceImpl;
	
	@ApiOperation(value="Get subject acronyms", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/getAllSubjectAcronyms")
	public List<String> getAllSubjectAcronym(){
		return schemeServiceImpl.getAllSubjectAcronym();
	}
	
	@ApiOperation(value="Get CourseId by Name", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/getCourseIdByName/{name}")
	public String getCourseIdByName(@PathVariable("name") String name){
		return coursesServiceImpl.getCourseIdByName(name);
	}
	
	@ApiOperation(value="Get Name by CourseId", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/getNameByCourseId/{courseId}")
	public String getNameByCourseId(@PathVariable("courseId") String courseId){
		return coursesServiceImpl.getNameByCourseId(courseId);
	}
	
	@ApiOperation(value="Get course list", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/getCourseList")
	public List<String> getCourseList(){
		return coursesServiceImpl.getCourseList();
	}
	
}
