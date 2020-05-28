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
import sgsits.cse.dis.administration.constants.RestAPI;
import sgsits.cse.dis.administration.feignClient.GatewayClient;
import sgsits.cse.dis.administration.jwt.JwtResolver;
import sgsits.cse.dis.administration.model.CWNComplaint;
import sgsits.cse.dis.administration.model.CleanlinessComplaint;
import sgsits.cse.dis.administration.model.ECCWComplaint;
import sgsits.cse.dis.administration.model.EMRComplaint;
import sgsits.cse.dis.administration.model.FacultyComplaint;
import sgsits.cse.dis.administration.model.LEComplaint;
import sgsits.cse.dis.administration.model.OtherComplaint;
import sgsits.cse.dis.administration.model.StudentComplaint;
import sgsits.cse.dis.administration.service.CleanlinessComplaintService;
import sgsits.cse.dis.administration.service.CwnComplaintService;
import sgsits.cse.dis.administration.service.EccwComplaintService;
import sgsits.cse.dis.administration.service.EmrComplaintService;
import sgsits.cse.dis.administration.service.FacultyComplaintService;
import sgsits.cse.dis.administration.service.LEComplaintService;
import sgsits.cse.dis.administration.service.OtherComplaintService;
import sgsits.cse.dis.administration.service.StudentComplaintService;

@CrossOrigin(origins = "*")
@RestController
@Api(value = "Complaints Resource")

public class ComplaintController {

	@Autowired
	private CleanlinessComplaintService cleanlinessComplaintService;

	@Autowired
	private LEComplaintService leComplaintService;

	@Autowired
	private CwnComplaintService cwnComplaintService;

	@Autowired
	private EmrComplaintService emrComplaintService;

	@Autowired
	private FacultyComplaintService facultyComplaintService;

	@Autowired
	private StudentComplaintService studentComplaintService;

	@Autowired
	private EccwComplaintService eccwComplaintService;
	
	@Autowired
	private OtherComplaintService otherComplaintService;

	@Autowired
	private GatewayClient gatewayClient;

	JwtResolver jwtResolver = new JwtResolver();

//	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintController.class);
	
	// My Complaints
	
	@ApiOperation(value = "Get My Cleanliness Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_MY_CLEANLINESS_COMPLAINTS, method = RequestMethod.GET)
	public List<CleanlinessComplaint> getMyCleanlinessComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return cleanlinessComplaintService.getMyComplaints(id);
	}
	
	@ApiOperation(value = "Get My LE Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_MY_LE_COMPLAINTS, method = RequestMethod.GET)
	public List<LEComplaint> getMyLEComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return leComplaintService.getMyComplaints(id);
	}
	

	@ApiOperation(value = "Get My Other Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_MY_OTHER_COMPLAINTS, method = RequestMethod.GET)
	public List<OtherComplaint> getMyOtherComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return otherComplaintService.getMyComplaints(id);
	}
	
	@ApiOperation(value = "Get My Faculty Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_MY_FACULTY_COMPLAINTS, method = RequestMethod.GET)
	public List<FacultyComplaint> getMyFacultyComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return facultyComplaintService.getMyComplaints(userType, id);
	}
	
	@ApiOperation(value = "Get My Student Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_MY_STUDENT_COMPLAINTS, method = RequestMethod.GET)
	public List<StudentComplaint> getMyStudentComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return studentComplaintService.getMyComplaints(userType, id);
	}

	//Resolved Complaints
	
	@ApiOperation(value = "Get Resolved Cleanliness Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_RESOLVED_CLEANLINESS_COMPLAINTS, method = RequestMethod.GET)
	public List<CleanlinessComplaint> getResolvedCleanlinessComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return cleanlinessComplaintService.getResolvedComplaints(id);
	}
	
	@ApiOperation(value = "Get Resolved LE Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_RESOLVED_LE_COMPLAINTS, method = RequestMethod.GET)
	public List<LEComplaint> getResolvedLEComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return leComplaintService.getResolvedComplaints(id);
	}


	@ApiOperation(value = "Get Resolved Other Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_RESOLVED_OTHER_COMPLAINTS, method = RequestMethod.GET)
	public List<OtherComplaint> getResolvedOtherComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return otherComplaintService.getResolvedComplaints(userType, id);
	}
	
	@ApiOperation(value = "Get Resolved Faculty Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_RESOLVED_FACULTY_COMPLAINTS, method = RequestMethod.GET)
	public List<FacultyComplaint> getResolvedFacultyComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return facultyComplaintService.getResolvedComplaints(userType, id);
	}
	
	@ApiOperation(value = "Get Resolved Student Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_RESOLVED_STUDENT_COMPLAINTS, method = RequestMethod.GET)
	public List<StudentComplaint> getResolvedStudentComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return studentComplaintService.getResolvedComplaints(userType, id);
	}
	
	@ApiOperation(value = "Get Resolved CWN Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_RESOLVED_CWN_COMPLAINTS, method = RequestMethod.GET)
	public List<CWNComplaint> getResolvedCWNComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return cwnComplaintService.getResolvedComplaints(id);
	}
	
	@ApiOperation(value = "Get Resolved ECCW Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_RESOLVED_ECCW_COMPLAINTS, method = RequestMethod.GET)
	public List<ECCWComplaint> getResolvedECCWComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return eccwComplaintService.getResolvedComplaints(id);
	}
	
	@ApiOperation(value = "Get Resolved EMRS Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_RESOLVED_EMRS_COMPLAINTS, method = RequestMethod.GET)
	public List<EMRComplaint> getResolvedEMRSComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return emrComplaintService.getResolvedComplaints(id);
	}

}
