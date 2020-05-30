package sgsits.cse.dis.administration.feignClient;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javassist.NotFoundException;

@FeignClient(name = "gateway")
public interface GatewayClient {
	
	@RequestMapping(value = "/dis/getUserType", method = RequestMethod.GET)
	public String getuserType(@RequestParam HttpServletRequest request);
	
	@RequestMapping(value = "/dis/getUserId", method = RequestMethod.GET)
	public String getUserId(@RequestParam("username") String username);
	
}
