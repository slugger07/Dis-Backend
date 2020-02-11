package sgsits.cse.dis.infrastructure.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javassist.NotFoundException;
import sgsits.cse.dis.infrastructure.response.ActiveStaffListResponse;

@FeignClient(name = "user")
public interface UserClient {
	
	@RequestMapping(value = "/userFeignClientController/getUserName", method = RequestMethod.GET)
	String getUserName(@RequestParam("id") String id);
	
	@RequestMapping(value = "/userFeignClientController/getUserType", method = RequestMethod.GET)
	String getUserType(@RequestParam("id") String id);
	
	@GetMapping(value = "/userFeignClientController/getActiveStaffList")
	List<ActiveStaffListResponse> getActiveStaffList() throws NotFoundException;

}