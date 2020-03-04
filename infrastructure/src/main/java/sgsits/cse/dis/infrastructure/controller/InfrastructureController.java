package sgsits.cse.dis.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.infrastructure.service.InfrastructureService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/infra") 
@Api(value = "Infrastructure Resource")
public class InfrastructureController {
	
	@Autowired
	InfrastructureService infrastructureService;
	
	@ApiOperation(value = "findIncharge", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/findIncharge", method = RequestMethod.GET)
	public List<String> findInchargeOf(@RequestParam("id") String id)
	{
		return infrastructureService.findInchargeOf(id);
	}
}
