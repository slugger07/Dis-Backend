package sgsits.cse.dis.infrastructure.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.infrastructure.jwt.JwtResolver;
import sgsits.cse.dis.infrastructure.model.Infrastructure;
import sgsits.cse.dis.infrastructure.request.UpdateInfraInchargeDetail;
import sgsits.cse.dis.infrastructure.response.InfrastructureInchargeResponse;
import sgsits.cse.dis.infrastructure.response.ResponseMessage;
import sgsits.cse.dis.infrastructure.service.InfrastructureService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/infra") 
@Api(value = "Infrastructure Resource")
public class InfrastructureController {
	
	@Autowired
	InfrastructureService infrastructureService;
	
	JwtResolver jwtResolver = new JwtResolver();
	
	@ApiOperation(value = "findIncharge", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/findIncharge", method = RequestMethod.GET)
	public List<String> findInchargeOf(@RequestParam("id") String id)
	{
		return infrastructureService.findInchargeOf(id);
	}
	
	@ApiOperation(value = "getInfraInchargeDetails", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getInfraInchargeDetails", method = RequestMethod.GET)
	public List<InfrastructureInchargeResponse> getInfraInchargeDetails(){
		return infrastructureService.getInfraInchargeDetails();
	}
	
	@ApiOperation(value = "updateInfraInchargeDetails", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/updateInfraInchargeDetails", method = RequestMethod.POST)
	public ResponseEntity<?> updateIncharge(@RequestBody UpdateInfraInchargeDetail details, HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		Infrastructure test = infrastructureService.updateIncharge(details, id);
		if (test != null)
			return new ResponseEntity<>(new ResponseMessage("Successfully updated."),
					HttpStatus.OK);
		else
			return new ResponseEntity<>(new ResponseMessage("Error occured. Try again later."),
					HttpStatus.BAD_REQUEST);
	}
}
