package sgsits.cse.dis.academics.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.academics.response.InfrastructureResponse;


/**
 * <h1><b>AcademicsClient</b> interface.</h1>
 * <p>This interface contains reference to controller "userFeignClientController" to 
 * ensure communication with <b>user</b> microservice.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-MAR-2020.
 */

@FeignClient(name = "infrastructure")
public interface InfrastuctureClient {
	
	
	@ApiOperation(value = "Get Infrastructure by type", response = InfrastructureResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = "/infrastructureFeignClientController/getInfrastructureByType/{type}", produces = "application/json")
	public List<InfrastructureResponse> getInfrastructureByType(@PathVariable("type") String type);
}
