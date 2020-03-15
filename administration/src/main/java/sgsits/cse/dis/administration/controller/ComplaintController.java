package sgsits.cse.dis.administration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.administration.constants.ComplaintConstants;
import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.jwt.JwtResolver;
import sgsits.cse.dis.administration.model.CWNComplaint;
import sgsits.cse.dis.administration.model.CleanlinessComplaint;
import sgsits.cse.dis.administration.model.ECCWComplaint;
import sgsits.cse.dis.administration.model.EMRComplaint;
import sgsits.cse.dis.administration.model.FacultyComplaint;
import sgsits.cse.dis.administration.model.LEComplaint;
import sgsits.cse.dis.administration.model.StudentComplaint;
import sgsits.cse.dis.administration.response.ResponseMessage;
import sgsits.cse.dis.administration.service.CleanlinessComplaintService;
import sgsits.cse.dis.administration.service.ComplaintService;
import sgsits.cse.dis.administration.service.FacultyComplaintService;
import sgsits.cse.dis.administration.service.StudentComplaintService;
import sgsits.cse.dis.administration.util.UserUtil;

@CrossOrigin(origins = "*")
@RestController
@Api(value = "Complaints Resource")

public class ComplaintController {

	@Autowired
	private CleanlinessComplaintService cleanlinessComplaintService;

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
	private UserUtil userUtil;

	JwtResolver jwtResolver = new JwtResolver();

	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintController.class);

	// Remaining Complaints

	@ApiOperation(value = "Get Remaining Cleanliness Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingCleanlinessComplaints", method = RequestMethod.GET)
	public List<CleanlinessComplaint> getRemainingCleanlinessComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> locations = infrastructureClient.findInchargeOf(id);
		if (locations != null) {
			return cleanlinessComplaintService.findAllRemainingComplaints(locations);
		} else {
			return null;
		}

	}

	@ApiOperation(value = "Get Remaining LE Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingLEComplaints", method = RequestMethod.GET)
	public List<LEComplaint> getRemainingLEComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> locations = infrastructureClient.findInchargeOf(id);
		if (locations != null) {
			return leComplaintService.findAllRemainingComplaints(locations);
		} else {
			return null;
		}

	}

	@ApiOperation(value = "Get Remaining CWN Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingCWNComplaints", method = RequestMethod.GET)
	public List<CWNComplaint> getRemainingCWNComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location != null) {
			return cwnComplaintService.findAllRemainingComplaints(location);
		} else {
			return null;
		}
	}

	@ApiOperation(value = "Get Remaining CWN Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingEMRSComplaints", method = RequestMethod.GET)
	public List<EMRComplaint> getRemainingEMRomplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location != null) {
			return emrComplaintService.findAllRemainingComplaints(location);
		} else {
			return null;
		}
	}

	@ApiOperation(value = "Get Remaining Faculty Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingFacultyComplaints", method = RequestMethod.GET)
	public List<FacultyComplaint> getRemainingFacultyComplaints(HttpServletRequest request) {
		String user_type = userUtil.getuserType(request);
		LOGGER.info("user type : ",user_type);
		if (user_type.equals("head")) {
			return facultyComplaintService.getRemainingFacultyComplaints();
		}
		return null;
	}
	
	//user type should also contain user who is assigned by head

	@ApiOperation(value = "Get Remaining Student Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingStudentComplaints", method = RequestMethod.GET)
	public List<StudentComplaint> getRemainingStudentComplaints(HttpServletRequest request) {
		String user_type = userUtil.getuserType(request);
		if (user_type.equals("head")) {
			return studentComplaintService.getRemainingStudentComplaints();
		}
		return null;
	}

	@ApiOperation(value = "Get Remaining ECCW Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingECCWComplaints", method = RequestMethod.GET)
	public List<ECCWComplaint> getRemainingECCWomplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location != null) {
			return eccwComplaintService.findAllRemainingComplaints(location);
		}
		return null;
	}

	@ApiOperation(value = "Add Cleanliness Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/addCleanlinessComplaint", method = RequestMethod.POST)
	public ResponseEntity<?> addCleanlinessComplaint(@RequestBody CleanlinessComplaint cleanlinessComplaintForm,
			HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		if (!cleanlinessComplaintService.checkIfComplaintExist(id, cleanlinessComplaintForm.getLocation(),
				"Resolved")) {
			CleanlinessComplaint test = cleanlinessComplaintService.addComplaint(cleanlinessComplaintForm, id);
			if (test != null)
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_SUCCESS),
						HttpStatus.OK);
			else
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_BAD_REQUEST),
						HttpStatus.BAD_REQUEST);
		} else
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ALREADY_EXIST),
					HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Add CWN Maintenance Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/addCWN", method = RequestMethod.POST)
	public ResponseEntity<?> addCWNComplaint(@RequestBody CWNComplaint cwnComplaints, HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		CWNComplaint test = cwnComplaintService.addComplaint(cwnComplaints, id);
		if (test != null)
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_SUCCESS),
					HttpStatus.OK);
		else
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_BAD_REQUEST),
					HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Add Engineering Cell / Central Workshop Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/addECCW", method = RequestMethod.POST)
	public ResponseEntity<?> addECCWComplaint(@RequestBody ECCWComplaint eccwComplaint, HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		ECCWComplaint test = eccwComplaintService.addComplaint(eccwComplaint, id);
		if (test != null)
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_SUCCESS),
					HttpStatus.OK);
		else
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_BAD_REQUEST),
					HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Add Electrical Maintenance and Repairs Section Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/addEMRS", method = RequestMethod.POST)
	public ResponseEntity<?> addEMRSComplaint(@RequestBody EMRComplaint emrComplaint, HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		EMRComplaint test = emrComplaintService.addComplaint(emrComplaint, id);
		if (test != null)
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_SUCCESS),
					HttpStatus.OK);
		else
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_BAD_REQUEST),
					HttpStatus.BAD_REQUEST);
	}
}
