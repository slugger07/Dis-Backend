package sgsits.cse.dis.administration.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.ApiOperation;

@FeignClient(name = "academics")
public interface AcademicsClient {
	
	@GetMapping(value = "/academicsFeignClientController/getAllSubjectAcronyms")
	public List<String> getAllSubjectAcronym();
	
	@GetMapping(value = "/academicsFeignClientController/getCourseIdByName/{name}")
	public String getCourseIdByName(@PathVariable("name") String name);
	
	@GetMapping(value = "/academicsFeignClientController/getNameByCourseId/{courseId}")
	public String getNameByCourseId(@PathVariable("courseId") String courseId);
	
	@GetMapping(value = "/academicsFeignClientController/getCourseList")
	public List<String> getCourseList();
}
