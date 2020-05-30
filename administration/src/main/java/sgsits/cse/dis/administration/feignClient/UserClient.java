package sgsits.cse.dis.administration.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user")
public interface UserClient {

	@RequestMapping(value = "/userFeignClientController/getUserId", method = RequestMethod.GET)
	public String getUserId(@RequestParam("username") String username);
	
}
