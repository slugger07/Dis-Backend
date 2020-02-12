package sgsits.cse.dis.infrastructure.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.infrastructure.response.FacultyData;

@FeignClient(name = "user")
public interface UserClient {
	
	@RequestMapping(value = "/userFeignClientController/getUserNameById/{userId}", method = RequestMethod.GET)
	String getUserNameById(@PathVariable String userId);
	
	@RequestMapping(value = "/userFeignClientController/getUserType", method = RequestMethod.GET)
	String getUserType(String id);
	
	@ApiOperation(value = "Staff name list", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/userFeignClientController/getStaffNameList", produces = "application/json")
	List<FacultyData> getStaffNameList();
	
	@ApiOperation(value = "Faculty name list", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/userFeignClientController/getFacultyNameList", produces = "application/json")
	List<FacultyData> getFacultyNameList();
}