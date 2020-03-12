package sgsits.cse.dis.administration.feignClient;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gateway")
public interface GatewayClient {
	
	@GetMapping(value = "/dis/getUserType")
	public String getUserType(HttpServletRequest request);
}
