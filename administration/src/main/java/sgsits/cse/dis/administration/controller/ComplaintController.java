package sgsits.cse.dis.administration.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.administration.constants.ComplaintConstants;
import sgsits.cse.dis.administration.constants.RestAPI;
import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.jwt.JwtResolver;
import sgsits.cse.dis.administration.model.CWNComplaint;
import sgsits.cse.dis.administration.model.CleanlinessComplaint;
import sgsits.cse.dis.administration.model.ECCWComplaint;
import sgsits.cse.dis.administration.model.EMRComplaint;
import sgsits.cse.dis.administration.model.FacultyComplaint;
import sgsits.cse.dis.administration.model.LEComplaint;
import sgsits.cse.dis.administration.model.OtherComplaint;
import sgsits.cse.dis.administration.model.StudentComplaint;
import sgsits.cse.dis.administration.model.TelephoneComplaint;
import sgsits.cse.dis.administration.request.CWNComplaintForm;
import sgsits.cse.dis.administration.request.CleanlinessComplaintForm;
import sgsits.cse.dis.administration.request.ComplaintDownloadReportForm;
import sgsits.cse.dis.administration.request.ECCWComplaintForm;
import sgsits.cse.dis.administration.request.EMRComplaintForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.request.FacultyComplaintForm;
import sgsits.cse.dis.administration.request.LEComplaintForm;
import sgsits.cse.dis.administration.request.OtherComplaintForm;
import sgsits.cse.dis.administration.request.StudentComplaintForm;
import sgsits.cse.dis.administration.request.TelephoneComplaintForm;
import sgsits.cse.dis.administration.response.ComplaintGeneralResponse;
import sgsits.cse.dis.administration.response.ResponseMessage;
import sgsits.cse.dis.administration.response.TelephoneComplaintResponse;
import sgsits.cse.dis.administration.service.CleanlinessComplaintService;
import sgsits.cse.dis.administration.service.CWNComplaintService;
import sgsits.cse.dis.administration.service.ECCWComplaintService;
import sgsits.cse.dis.administration.service.EMRComplaintService;
import sgsits.cse.dis.administration.service.FacultyComplaintService;
import sgsits.cse.dis.administration.service.LEComplaintService;
import sgsits.cse.dis.administration.service.OtherComplaintService;
import sgsits.cse.dis.administration.service.StudentComplaintService;
import sgsits.cse.dis.administration.service.TelephoneComplaintService;

@Api(value = "Complaints Resource")
@CrossOrigin(origins = "*")
@RestController
public class ComplaintController {

	@Autowired
	private CleanlinessComplaintService cleanlinessComplaintService;

	@Autowired
	private LEComplaintService leComplaintService;

	@Autowired
	private CWNComplaintService cwnComplaintService;

	@Autowired
	private EMRComplaintService emrComplaintService;

	@Autowired
	private FacultyComplaintService facultyComplaintService;

	@Autowired
	private StudentComplaintService studentComplaintService;

	@Autowired
	private ECCWComplaintService eccwComplaintService;
	
	@Autowired
	private OtherComplaintService otherComplaintService;
	
	@Autowired
	private TelephoneComplaintService telephoneComplaintService; 

	@Autowired
	private InfrastructureClient infrastructureClient;
	
	JwtResolver jwtResolver = new JwtResolver();
	
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
//		String userName = jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
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
		String userName = jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return otherComplaintService.getResolvedComplaints(userType, userName);
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
	
	@ApiOperation(value = "Get Resolved Telephone Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_RESOLVED_TELEPHONE_COMPLAINTS, method = RequestMethod.GET)
	public List<TelephoneComplaint> getResolvedTelephoneComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return telephoneComplaintService.getResolvedComplaints(id);
	}
	
	//Total complaints -> CWN, ECCW, EMRS, Telephone
	@ApiOperation(value = "Get Total CWN Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_TOTAL_CWN_COMPLAINTS, method = RequestMethod.GET)
	public List<CWNComplaint> getTotalCWNComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return cwnComplaintService.getTotalComplaints(id);
	}
	
	@ApiOperation(value = "Get Total ECCW Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_TOTAL_ECCW_COMPLAINTS, method = RequestMethod.GET)
	public List<ECCWComplaint> getTotalECCWComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return eccwComplaintService.getTotalComplaints(id);
	}
	
	@ApiOperation(value = "Get Total EMRS Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_TOTAL_EMRS_COMPLAINTS, method = RequestMethod.GET)
	public List<EMRComplaint> getTotalEMRSComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return emrComplaintService.getTotalComplaints(id);
	}

	@ApiOperation(value = "Get Total Telephone Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_TOTAL_TELEPHONE_COMPLAINTS, method = RequestMethod.GET)
	public List<TelephoneComplaint> getTotalTelephoneComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return telephoneComplaintService.getTotalComplaints(id);
	}
	
	//Remaining Complaints -> Other, EMRS, Telephone
	@ApiOperation(value = "Get Remaining Other Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_REMAINING_OTHER_COMPLAINTS, method = RequestMethod.GET)
	public List<OtherComplaint> getRemainingOtherComplaints(HttpServletRequest request) {
		String userName = jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		return otherComplaintService.getRemainingComplaints(userType, userName);
	}
	
	@ApiOperation(value = "Get Remaining EMRS Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_REMAINING_EMRS_COMPLAINTS, method = RequestMethod.GET)
	public List<EMRComplaint> getRemainingEMRSComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return emrComplaintService.getRemainingComplaints(id);
	}
	
	@ApiOperation(value = "Get Remaining Cleanliness Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_REMAINING_CLEANLINESS_COMPLAINTS, method = RequestMethod.GET)
	public List<CleanlinessComplaint> getRemainingCleanlinessComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> locations = infrastructureClient.findInchargeOf(id);
		if (locations != null) {
			return cleanlinessComplaintService.findAllRemainingComplaints(locations);
		}
		return null;
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

	@ApiOperation(value = "Get Remaining Faculty Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingFacultyComplaints", method = RequestMethod.GET)
	public List<FacultyComplaint> getRemainingFacultyComplaints(HttpServletRequest request) {
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		//LOGGER.info("user type : ", userType);
		if (userType.equals("head")) {
			return facultyComplaintService.getRemainingFacultyComplaints();
		}
		return null;
	}

	// user type should also contain user who is assigned by head

	@ApiOperation(value = "Get Remaining Student Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingStudentComplaints", method = RequestMethod.GET)
	public List<StudentComplaint> getRemainingStudentComplaints(HttpServletRequest request) {
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		if (userType.equals("head")) {
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
	
	
	@ApiOperation(value = "Get Remaining Telephone Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getRemainingTelephoneComplaints", method = RequestMethod.GET)
	public List<TelephoneComplaint> getRemainingTelephoneomplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location != null) {
			return telephoneComplaintService.findAllRemainingComplaints(location);
		}
		return null;
	}

	@ApiOperation(value = "Add Cleanliness Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/addCleanlinessComplaint", method = RequestMethod.POST)
	public ResponseEntity<?> addCleanlinessComplaint(@RequestBody CleanlinessComplaintForm cleanlinessComplaintForm,
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
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ALREADY_EXIST), HttpStatus.BAD_REQUEST);
	}

	// not adding form id and pdf id
	@ApiOperation(value = "Add CWN Maintenance Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/addCWNComplaint", method = RequestMethod.POST)
	public ResponseEntity<?> addCWNComplaint(@RequestBody List<CWNComplaintForm> cwnComplaints,
			HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student")) {
			List<CWNComplaint> test = cwnComplaintService.addMutipleComplaints(cwnComplaints, id);
			if (test != null)
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_SUCCESS),
						HttpStatus.OK);
			else
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_BAD_REQUEST),
						HttpStatus.BAD_REQUEST);
		} else
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.NEED_PERMISSION),
					HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Add Engineering Cell / Central Workshop Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/addECCWComplaint", method = RequestMethod.POST)
	public ResponseEntity<?> addECCWComplaint(@RequestBody List<ECCWComplaintForm> eccwComplaint,
			HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student")) {
			List<ECCWComplaint> test = eccwComplaintService.addMultipleComplaint(eccwComplaint, id);
			if (test != null)
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_SUCCESS),
						HttpStatus.OK);
			else
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_BAD_REQUEST),
						HttpStatus.BAD_REQUEST);
		} else
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.NEED_PERMISSION),
					HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value = "Add Electrical Maintenance and Repairs Section Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/addEMRSComplaint", method = RequestMethod.POST)
	public ResponseEntity<?> addEMRSComplaint(@RequestBody List<EMRComplaintForm> emrComplaints,
			HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student")) {
			List<EMRComplaint> test = emrComplaintService.addMultipleComplaint(emrComplaints, id);
			if (test != null)
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_SUCCESS),
						HttpStatus.OK);
			else
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_BAD_REQUEST),
						HttpStatus.BAD_REQUEST);
		} else
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.NEED_PERMISSION),
					HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value = "Add Lab Equipment Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = RestAPI.ADD_LE_COMPLAINTS, method = RequestMethod.POST)
	public ResponseEntity<?> addLEComplaint(@RequestBody LEComplaintForm leComplaintForm, HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		if (leComplaintService.checkIfComplaintExist(id, leComplaintForm.getLab(), leComplaintForm.getSystemNo(),
				"Resolved")) {
			LEComplaint test = leComplaintService.addComplaint(leComplaintForm, id);
			if (test != null)
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_SUCCESS),
						HttpStatus.OK);
			else
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_BAD_REQUEST),
						HttpStatus.BAD_REQUEST);
		} else
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ALREADY_EXIST), HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Add Other Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = RestAPI.ADD_OTHER_COMPLAINTS, method = RequestMethod.POST)
	public ResponseEntity<?> addOtherComplaint(@RequestBody OtherComplaintForm otherComplaintForm,
			HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		if (otherComplaintService.checkIfComplaintExist(id, otherComplaintForm.getDetails(), "Resolved")) {
			OtherComplaint test = otherComplaintService.addComplaint(otherComplaintForm, id);
			if (test != null)
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_SUCCESS),
						HttpStatus.OK);
			else
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_BAD_REQUEST),
						HttpStatus.BAD_REQUEST);
		} else
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ALREADY_EXIST), HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value = "Add Student Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = RestAPI.ADD_STUDENT_COMPLAINTS, method = RequestMethod.POST)
	public ResponseEntity<?> addStudentComplaint(@RequestBody StudentComplaintForm studentComplaintForm,
			HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		if (jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("faculty")) {
			boolean check1 = studentComplaintService.existsByCreatedByAndRollNoAndNameAndYearAndStatusNot(id,
					studentComplaintForm.getStudentRollNo(), studentComplaintForm.getStudentName(),
					studentComplaintForm.getYear(), "Resolved");
			boolean check2 = studentComplaintService.existsByCreatedByAndRollNoAndYearAndStatusNot(id,
					studentComplaintForm.getStudentRollNo(), studentComplaintForm.getYear(), "Resolved");
			boolean check3 = studentComplaintService.existsByCreatedByAndNameAndYearAndStatusNot(id,
					studentComplaintForm.getStudentName(), studentComplaintForm.getYear(), "Resolved");
			if (check1 || check2 || check3) {
				StudentComplaint test = studentComplaintService.addComplaint(studentComplaintForm, id);
				if (test != null)
					return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_SUCCESS),
							HttpStatus.OK);
				else
					return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_BAD_REQUEST),
							HttpStatus.BAD_REQUEST);
			} else
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ALREADY_EXIST),
						HttpStatus.BAD_REQUEST);

		} else
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.NEED_PERMISSION),
					HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value = "Add Telephone Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = RestAPI.ADD_TELEPHONE_COMPLAINTS, method = RequestMethod.POST)
	public ResponseEntity<?> addTelephoneComplaint(@RequestBody List<TelephoneComplaintForm> telephoneComplaintForm,
			HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student")) {
			List<TelephoneComplaint> test = telephoneComplaintService.addMultipleComplaint(telephoneComplaintForm, id);
			if (test != null)
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_SUCCESS),
						HttpStatus.OK);
			else
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_BAD_REQUEST),
						HttpStatus.BAD_REQUEST);
		} else
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ALREADY_EXIST), HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value = "Add Faculty Complaint", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = RestAPI.ADD_FACULTY_COMPLAINTS, method = RequestMethod.POST)
	public ResponseEntity<?> addFacultyComplaint(@RequestBody FacultyComplaintForm facultyComplaintForm,
			HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		if (jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student")) {
			FacultyComplaint test = facultyComplaintService.addComplaint(facultyComplaintForm, id);
			if (test != null)
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_SUCCESS),
						HttpStatus.OK);
			else
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ADD_COMPLAINT_BAD_REQUEST),
						HttpStatus.BAD_REQUEST);
		} else
			return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.ALREADY_EXIST), HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value = "Edit Complaint", response = Object.class, httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = RestAPI.EDIT_COMPLAINTS, method = RequestMethod.PUT)
	public ResponseEntity<?> editComplaint(@RequestBody EditComplaintForm editComplaintForm,
			HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));

		switch (editComplaintForm.getType()) {

		case "CLEANLINESS":
			CleanlinessComplaint cleanlinessComplaint = cleanlinessComplaintService.editComplaint(editComplaintForm,
					id);
			if (cleanlinessComplaint != null) {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.SUCCESSFULLY_UPDATED),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.CANNOT_FIND),
						HttpStatus.BAD_REQUEST);
			}

		case "LE":
			LEComplaint leComplaint = leComplaintService.editComplaint(editComplaintForm, id);
			if (leComplaint != null) {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.SUCCESSFULLY_UPDATED),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.CANNOT_FIND),
						HttpStatus.BAD_REQUEST);
			}

		case "STUDENT":
			StudentComplaint studentComplaint = studentComplaintService.editComplaint(editComplaintForm, id);
			if (studentComplaint != null) {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.SUCCESSFULLY_UPDATED),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.CANNOT_FIND),
						HttpStatus.BAD_REQUEST);
			}

		case "FACULTY":
			FacultyComplaint facultyComplaint = facultyComplaintService.editComplaint(editComplaintForm, id);
			if (facultyComplaint != null) {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.SUCCESSFULLY_UPDATED),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.CANNOT_FIND),
						HttpStatus.BAD_REQUEST);
			}

		case "OTHER":
			OtherComplaint otherComplaint = otherComplaintService.editComplaint(editComplaintForm, id);
			if (otherComplaint != null) {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.SUCCESSFULLY_UPDATED),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.CANNOT_FIND),
						HttpStatus.BAD_REQUEST);
			}

		case "CWN":
			CWNComplaint cwnComplaint = cwnComplaintService.editComplaint(editComplaintForm, id);
			if (cwnComplaint != null) {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.SUCCESSFULLY_UPDATED),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.CANNOT_FIND),
						HttpStatus.BAD_REQUEST);
			}

		case "ECCW":
			ECCWComplaint eccwComplaint = eccwComplaintService.editComplaint(editComplaintForm, id);
			if (eccwComplaint != null) {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.SUCCESSFULLY_UPDATED),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.CANNOT_FIND),
						HttpStatus.BAD_REQUEST);
			}

		case "EMR":
			EMRComplaint emrComplaint = emrComplaintService.editComplaint(editComplaintForm, id);
			if (emrComplaint != null) {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.SUCCESSFULLY_UPDATED),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.CANNOT_FIND),
						HttpStatus.BAD_REQUEST);
			}

		case "TELEPHONE":
			TelephoneComplaint telephoneComplaint = telephoneComplaintService.editComplaint(editComplaintForm, id);
			if (telephoneComplaint != null) {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.SUCCESSFULLY_UPDATED),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ResponseMessage(ComplaintConstants.CANNOT_FIND),
						HttpStatus.BAD_REQUEST);
			}
		}
		return null;
	}

	@ApiOperation(value = "Get Remaining Complaints Count", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_REMAINING_COMPLAINTS_COUNT, method = RequestMethod.GET)
	public long getRemainingComplaintsCount(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userName = jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
		String user_type = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		long count = 0;
		if (user_type.equals("head")) {
			count = count + facultyComplaintService.countByStatusNot("Resolved");
			count = count + studentComplaintService.countByStatusNot("Resolved");
			count = count + otherComplaintService.countByStatusNot("Resolved");
		} else {
			List<String> location = infrastructureClient.findInchargeOf(id);
			count = count + cleanlinessComplaintService.countByLocationInAndStatusNot(location, "Resolved");
			count = count + cwnComplaintService.countByLocationInAndStatusNot(location, "Resolved");
			count = count + eccwComplaintService.countByLocationInAndStatusNot(location, "Resolved");
			count = count + emrComplaintService.countByLocationInAndStatusNot(location, "Resolved");
			count = count + leComplaintService.countByLabInAndStatusNot(location, "Resolved");
			count = count + telephoneComplaintService.countByLocationInAndStatusNot(location, "Resolved");
			count = count + otherComplaintService.countByAssignedToAndStatusNot(userName, "Resolved");
		}
		return count;
	}

	@GetMapping(value = "/count")
	public long getComplaintCount(HttpServletRequest request) {
		return cleanlinessComplaintService.count();
	}

	@GetMapping(value = "/countIn")
	public long getComplaintInCount(HttpServletRequest request) {
		return cleanlinessComplaintService.countIn();
	}

	@ApiOperation(value = "Get Resolved Complaints Count", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_RESOLVED_COMPLAINTS_COUNT, method = RequestMethod.GET)
	public long getResolvedComplaintsCount(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userName = jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
		String user_type = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		long count = 0;
		if (user_type.equals("head")) {
			count = count + facultyComplaintService.countByStatus("Resolved");
			count = count + studentComplaintService.countByStatus("Resolved");
			count = count + otherComplaintService.countByStatus("Resolved");
		} else {
			List<String> loc = infrastructureClient.findInchargeOf(id);
			count = count + cleanlinessComplaintService.countByLocationInAndStatus(loc, "Resolved");
			count = count + cwnComplaintService.countByLocationInAndStatus(loc, "Resolved");
			count = count + eccwComplaintService.countByLocationInAndStatus(loc, "Resolved");
			count = count + emrComplaintService.countByLocationInAndStatus(loc, "Resolved");
			count = count + leComplaintService.countByLabInAndStatus(loc, "Resolved");
			count = count + telephoneComplaintService.countByLocationInAndStatus(loc, "Resolved");
			count = count + otherComplaintService.countByAssignedToAndStatus(userName, "Resolved");

		}
		return count;
	}

	@ApiOperation(value = "Get Total Complaints Count", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_TOTAL_COMPLAINTS_COUNT, method = RequestMethod.GET)
	public long getTotalComplaintsCount(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userName = jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
		String user_type = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		long count = 0;
		if (user_type.equals("head")) {
			count = count + facultyComplaintService.countAll();
			count = count + studentComplaintService.countAll();
			count = count + otherComplaintService.countAll();
		} else {
			List<String> loc = infrastructureClient.findInchargeOf(id);
			count = count + cleanlinessComplaintService.countByLocationIn(loc);
			count = count + cwnComplaintService.countByLocationIn(loc);
			count = count + eccwComplaintService.countByLocationIn(loc);
			count = count + emrComplaintService.countByLocationIn(loc);
			count = count + leComplaintService.countByLabIn(loc);
			count = count + telephoneComplaintService.countByLocationIn(loc);
			count = count + otherComplaintService.countByAssignedTo(userName);
		}
		return count;
	}

	@ApiOperation(value = "Get My Complaints Count", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_MY_COMPLAINTS_COUNT, method = RequestMethod.GET)
	public long getMyComplaintsCount(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String user_type = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		long count = 0;
		count = count + cleanlinessComplaintService.countByCreatedBy(id);
		count = count + leComplaintService.countByCreatedBy(id);
		count = count + otherComplaintService.countByCreatedBy(id);
		if (user_type.equals("student")) {
			count = count + facultyComplaintService.countByCreatedBy(id);
		}
		if (user_type.equals("faculty")) {
			count = count + studentComplaintService.countByCreatedBy(id);
		}
		return count;
	}
	
	@ApiOperation(value = "Get Total Cleanliness Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_TOTAL_CLEANLINESS_COMPLAINTS, method = RequestMethod.GET)
	public List<CleanlinessComplaint> getTotalCleanlinessComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location != null)
			return cleanlinessComplaintService.findByLocationIn(location);
		else
			return null;
	}

	@ApiOperation(value = "Get Total LE Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_TOTAL_LE_COMPLAINTS, method = RequestMethod.GET)
	public List<LEComplaint> getTotalLEComplaints(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location != null)
			return leComplaintService.findByLabIn(location);
		else
			return null;
	}

	@ApiOperation(value = "Get Total Other Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_TOTAL_OTHER_COMPLAINTS, method = RequestMethod.GET)
	public List<OtherComplaint> getTotalOtherComplaints(HttpServletRequest request) {
		String userName = jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
		String user_type = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		if (user_type.equals("head")) {
			return otherComplaintService.findAll();
		}
		return otherComplaintService.findByAssignedTo(userName);
	}

	@ApiOperation(value = "Get Total Faculty Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_TOTAL_FACULTY_COMPLAINTS, method = RequestMethod.GET)
	public List<FacultyComplaint> getTotalFacultyComplaints(HttpServletRequest request) {
		String user_type = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		if (user_type.equals("head")) {
			return facultyComplaintService.findAll();
		}
		return null;
	}

	@ApiOperation(value = "Get Total Student Complaints", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_TOTAL_STUDENT_COMPLAINTS, method = RequestMethod.GET)
	public List<StudentComplaint> getTotalStudentComplaints(HttpServletRequest request) {
		String user_type = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		if (user_type.equals("head")) {
			return studentComplaintService.findAll();
		}
		return null;
	}
	
	//use switch case as used in edit complaints and create an api for telephone and one api for other three
	@ApiOperation(value = "Get CWN/ECCW/EMR complaints of a type on a particular date", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getComplaintsOnDate", method= RequestMethod.GET)
	public List<ComplaintGeneralResponse> getDownloadReportData(@RequestParam(value="complaintType") String complaintType, @RequestParam(value="createdDate") String createdDate, @RequestParam(value="location") String location ,HttpServletRequest request) {
		//String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		ComplaintDownloadReportForm complaintInfo = new ComplaintDownloadReportForm();
		complaintInfo.setComplaintType(complaintType);
		complaintInfo.setCreatedDate(createdDate);
		complaintInfo.setLocation(location);
		List<ComplaintGeneralResponse> complaints = new ArrayList<>();
		switch(complaintInfo.getComplaintType()) {
		case "CWN":
			complaints = cwnComplaintService.getDownloadReportData(complaintInfo);
			break;
		case "ECCW":
			complaints = eccwComplaintService.getDownloadReportData(complaintInfo);
			break;
		case "EMR":
			complaints = emrComplaintService.getDownloadReportData(complaintInfo);
			break;	
		}
		return complaints;
	}
	
	@ApiOperation(value = "Get Telephone complaints of a type on a particular date", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getTelephoneComplaintsOnDate", method= RequestMethod.GET)
	public List<TelephoneComplaintResponse> getDownloadReportDataForTelephone(@RequestParam(value="complaintType") String complaintType, @RequestParam(value="createdDate") String createdDate, @RequestParam(value="location") String location , HttpServletRequest request) {
		List<TelephoneComplaintResponse> complaints = new ArrayList<>();
		ComplaintDownloadReportForm complaintInfo = new ComplaintDownloadReportForm();
		complaintInfo.setComplaintType(complaintType);
		complaintInfo.setCreatedDate(createdDate);
		complaintInfo.setLocation(location);
		complaints = telephoneComplaintService.getDownloadReportData(complaintInfo);
		return complaints;
	}
	
		
}
