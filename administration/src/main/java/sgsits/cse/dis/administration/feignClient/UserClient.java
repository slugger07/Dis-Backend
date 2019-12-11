package sgsits.cse.dis.administration.feignClient;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user")
public interface UserClient {

	@GetMapping(value = "/userFeignClientController/existsByUsername/{username}")
	public boolean existsByUsername(@PathVariable String username);
}
