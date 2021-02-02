package sgsits.cse.dis.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.infrastructure.constants.RestAPI;
import sgsits.cse.dis.infrastructure.response.InfrastructureBrief;
import sgsits.cse.dis.infrastructure.response.InfrastructureResponse;
import sgsits.cse.dis.infrastructure.service.InfrastructureService;

/**
 * <h1>InfrastructureFeignClientController.</h1>
 * <p>This controller exposes user services as REST end points at default path <b>/userFeignCliemntController</b>.
 * These servies are meant to be consumed only by feignClient in any other microservice.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-MAR-2020.
 */

@Api(value = "infrastructure Feign Client Controller")
@RestController
@RequestMapping(path = "/infrastructureFeignClientController")
public class InfrastructureFeignClientController {
	
	@Autowired
	private InfrastructureService infrastructureService;
	
	@ApiOperation(value = "Get Infrastructure by type", response = InfrastructureBrief.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_INFRASTRUCTURE_BY_TYPE, produces = "application/json")
	public ResponseEntity<List<InfrastructureResponse>> getInfrastructureByType(@PathVariable("type") String type) {
		return new ResponseEntity<List<InfrastructureResponse>>(infrastructureService.getInfrastructureNameAndIdByType(type),
				HttpStatus.OK);
	}
}
