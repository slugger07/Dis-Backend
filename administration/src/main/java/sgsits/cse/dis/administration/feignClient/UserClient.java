package sgsits.cse.dis.administration.feignClient;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <h1><b>AcademicsClient</b> interface.</h1>
 * <p>This interface contains reference to controller "userFeignClientController" to 
 * ensure communication with <b>user</b> microservice.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-DEC-2019.
 */

@FeignClient(name = "user")
public interface UserClient {

	@GetMapping(value = "/userFeignClientController/existsByUsername/{username}")
	public boolean existsByUsername(@PathVariable String username);
}
