package sgsits.cse.dis.administration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.administration.feignClient.GatewayClient;
import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.jwt.JwtResolver;
import sgsits.cse.dis.administration.model.CWNComplaint;
import sgsits.cse.dis.administration.model.CleanlinessComplaint;
import sgsits.cse.dis.administration.model.ECCWComplaint;
import sgsits.cse.dis.administration.model.EMRComplaint;
import sgsits.cse.dis.administration.model.FacultyComplaint;
import sgsits.cse.dis.administration.model.LEComplaint;
import sgsits.cse.dis.administration.model.StudentComplaint;
import sgsits.cse.dis.administration.service.ComplaintService;
import sgsits.cse.dis.administration.service.FacultyComplaintService;
import sgsits.cse.dis.administration.service.StudentComplaintService;

@CrossOrigin(origins = "*")
@RestController
@Api(value = "Complaints Resource")

public class ComplaintController {

	@Autowired
	private ComplaintService<CleanlinessComplaint> cleanlinessComplaintService;
	
	@Autowired
	private ComplaintService<LEComplaint> leComplaintService;
		
	@Autowired
	private ComplaintService<CWNComplaint> cwnComplaintService;
	
	@Autowired
	private ComplaintService<EMRComplaint> emrComplaintService;
	
	@Autowired
	private FacultyComplaintService facultyComplaintService;
	
	@Autowired
	private StudentComplaintService studentComplaintService;
	
	@Autowired
	private ComplaintService<ECCWComplaint> eccwComplaintService;
	
	
	@Autowired
	private InfrastructureClient infrastructureClient;
	
	
	@Autowired
	private GatewayClient gatewayClient;

	JwtResolver jwtResolver = new JwtResolver();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintController.class);
	
	//Remaining Complaints

	@ApiOperation(value = "Get Remaining Cleanliness Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingCleanlinessComplaints", method = RequestMethod.GET)
	public List<CleanlinessComplaint> getRemainingCleanlinessComplaints(HttpServletRequest request)
	{
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> locations = infrastructureClient.findInchargeOf(id);
		if(locations != null) {
			return cleanlinessComplaintService.findAllRemainingComplaints(locations);
		}
		else {
			return null;
		}
		
	}
	
	@ApiOperation(value = "Get Remaining LE Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingLEComplaints", method = RequestMethod.GET)
	public List<LEComplaint> getRemainingLEComplaints(HttpServletRequest request)
	{
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> locations = infrastructureClient.findInchargeOf(id);
		if(locations != null) {
			return leComplaintService.findAllRemainingComplaints(locations);
		}
		else {
			return null;
		}
		
	}
	
	@ApiOperation(value = "Get Remaining CWN Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingCWNComplaints", method = RequestMethod.GET)
	public List<CWNComplaint> getRemainingCWNComplaints(HttpServletRequest request)
	{
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> location = infrastructureClient.findInchargeOf(id);
		if(location != null) {
			return cwnComplaintService.findAllRemainingComplaints(location);
		}
		else {
			return null;
		}
	}
	
	@ApiOperation(value = "Get Remaining CWN Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingEMRSComplaints", method = RequestMethod.GET)
	public List<EMRComplaint> getRemainingEMRomplaints(HttpServletRequest request)
	{
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> location = infrastructureClient.findInchargeOf(id);
		if(location != null) {
			return emrComplaintService.findAllRemainingComplaints(location);
		}
		else {
			return null;
		}
	}
	
	@ApiOperation(value = "Get Remaining Faculty Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingFacultyComplaints", method = RequestMethod.GET)
	public List<FacultyComplaint> getRemainingFacultyComplaints(HttpServletRequest request)
	{
		String user_type = gatewayClient.getUserType(request);
		if (user_type.equals("head")) {
			return facultyComplaintService.getRemainingFacultyComplaints();
		}
		return null;
	}
	
	@ApiOperation(value = "Get Remaining Student Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingStudentComplaints", method = RequestMethod.GET)
	public List<StudentComplaint> getRemainingStudentComplaints(HttpServletRequest request)
	{
		String user_type = gatewayClient.getUserType(request);
		if (user_type.equals("head")) {
			return studentComplaintService.getRemainingStudentComplaints();
		}
		return null;
	}
	
	@ApiOperation(value = "Get Remaining ECCW Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingECCWComplaints", method = RequestMethod.GET)
	public List<ECCWComplaint> getRemainingECCWomplaints(HttpServletRequest request)
	{
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> location = infrastructureClient.findInchargeOf(id);
		if(location != null) {
			return eccwComplaintService.findAllRemainingComplaints(location);
		}
		return null;
	}
	
	
}
