package sgsits.cse.dis.administration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.jwt.JwtResolver;
import sgsits.cse.dis.administration.model.CleanlinessComplaint;
import sgsits.cse.dis.administration.service.CleanlinessComplaintService;

@CrossOrigin(origins = "*")
@RestController
@Api(value = "Complaints Resource")

public class ComplaintController {

	@Autowired
	private CleanlinessComplaintService cleanlinessComplaintService;
	
//	@Autowired
//	private ComplaintService<CleanlinessComplaint> cleanlinessComplaintService1;
	
	
	@Autowired
	private InfrastructureClient infrastructureClient;

	JwtResolver jwtResolver = new JwtResolver();
	
	//Remaining Complaints

	@ApiOperation(value = "Get Remaining Cleanliness Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingCleanlinessComplaints", method = RequestMethod.GET)
	public List<CleanlinessComplaint> getRemainingCleanlinessComplaints(HttpServletRequest request)
	{
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> locations = infrastructureClient.findInchargeOf(id);
		if(locations != null) {
			return cleanlinessComplaintService.getAllCleanlinessComplaints(locations);
		}
		else {
			return null;
		}
		
	}
	
	
}
