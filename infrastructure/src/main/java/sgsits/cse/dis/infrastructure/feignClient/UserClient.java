package sgsits.cse.dis.infrastructure.feignClient;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.infrastructure.response.FacultyData;

/**
 * <h1><b>AcademicsClient</b> interface.</h1>
 * <p>
 * This interface contains reference to controller "userFeignClientController"
 * to ensure communication with <b>user</b> microservice.
 * 
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-DEC-2019.
 */
@FeignClient(name = "user")
public interface UserClient {

	@RequestMapping(value = "/userFeignClientController/getUserNameById/{userId}")
	String getUserNameById(@PathVariable String userId);

	@RequestMapping(value = "/userFeignClientController/getUserNameByIdOptional", method = RequestMethod.POST)
	String getUserNameByIdOptional(@RequestBody Optional<String> userId);

	@RequestMapping(value = "/userFeignClientController/getUserType", method = RequestMethod.GET)
	String getUserType(String id);

	@ApiOperation(value = "Staff name list", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/userFeignClientController/getStaffNameList", produces = "application/json")
	List<FacultyData> getStaffNameList();

	@ApiOperation(value = "Faculty name list", response = FacultyData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/userFeignClientController/getFacultyNameList", produces = "application/json")
	List<FacultyData> getFacultyNameList();
}