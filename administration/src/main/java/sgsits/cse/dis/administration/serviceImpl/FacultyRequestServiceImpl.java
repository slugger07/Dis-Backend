package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.exception.ResourceRequestNotAccessibleException;
import sgsits.cse.dis.administration.exception.ResourceRequestNotFoundException;
import sgsits.cse.dis.administration.feignClient.UserClient;
import sgsits.cse.dis.administration.jwt.JwtResolver;
import sgsits.cse.dis.administration.model.FacultyRequest;
import sgsits.cse.dis.administration.repo.FacultyRequestRepo;
import sgsits.cse.dis.administration.request.FacultyRequestEditForm;
import sgsits.cse.dis.administration.request.FacultyRequestForm;
import sgsits.cse.dis.administration.service.FacultyRequestService;

@Service
public class FacultyRequestServiceImpl implements FacultyRequestService {
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private FacultyRequestRepo facultyRequestRepo;
	
	private static String assignedToDefault = "pbamne";
	
	JwtResolver jwtResolver = new JwtResolver();

	@Override
	public FacultyRequest addRequest(FacultyRequestForm facultyRequestForm, HttpServletRequest request) {
		String createdById = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String createdByUsername = jwtResolver.getUserNameFromJwtToken(request.getHeader("Authorization"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		FacultyRequest facultyRequest = new FacultyRequest();
		facultyRequest.setCreatedBy(createdById);
		facultyRequest.setUsername(createdByUsername);
		facultyRequest.setCategory(facultyRequestForm.getCategory());
		facultyRequest.setDetails(facultyRequestForm.getDetails());
		facultyRequest.setCreatedDate(simpleDateFormat.format(new Date()));
		facultyRequest.setAssignedPersonId(userClient.getUserId(assignedToDefault));
		facultyRequest.setAssignedPersonUsername(assignedToDefault);
		facultyRequest.setStatus("Not resolved");
//		getting the ID of the assignedToDefault person from the feign client of user service.
		FacultyRequest result = facultyRequestRepo.save(facultyRequest);
		return result;
	}
	
	@Override
	public FacultyRequest getRequest(String requestId, HttpServletRequest request) {
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		System.out.println(userType);
		Optional<FacultyRequest> resourceRequest = null;
		if (!userType.equals("student")) {
			resourceRequest = facultyRequestRepo.findById(requestId);
			if (!resourceRequest.isPresent()) throw new ResourceRequestNotFoundException("Resource not found");
			else {
				FacultyRequest existingRequest = resourceRequest.get();
				return existingRequest;
			}
		}
		throw new ResourceRequestNotAccessibleException("You cannot access this resource!");
	}

	@Override
	public FacultyRequest updateRequest(String requestId, FacultyRequestEditForm facultyRequestEditForm,
			HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (id.equals(userClient.getUserId(assignedToDefault))) {
			if (facultyRequestRepo.findById(requestId).isPresent()) {
				FacultyRequest existingRequest = facultyRequestRepo.findById(requestId).get();
				existingRequest.setAssignedPersonId(facultyRequestEditForm.getAssignedPersonId());
				existingRequest.setModifiedBy(id);
				existingRequest.setModifiedDate(simpleDateFormat.format(new Date()));
				FacultyRequest updatedRequest = facultyRequestRepo.save(existingRequest);
				return updatedRequest;
			}
			throw new ResourceRequestNotFoundException("Resource not found");
		}
		throw new ResourceRequestNotAccessibleException("You cannot access this resource!");
	}

	@Override
	public List<FacultyRequest> getUnresolvedRequestsById(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		return facultyRequestRepo.findByCreatedByAndStatusNotOrderByCreatedDateDesc(id, "Resolved");
	}

	@Override
	public List<FacultyRequest> getAllResolvedRequests(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String defaultId = userClient.getUserId(assignedToDefault);
		if (defaultId.equals(id)) {
			return facultyRequestRepo.findByStatus("Resolved");
		}
		throw new ResourceRequestNotAccessibleException("You cannot access this resource!");
	}

	@Override
	public List<FacultyRequest> getAllUnresolvedRequests(HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		String defaultId = userClient.getUserId(assignedToDefault);
		if (defaultId.equals(id) || userType.equals("head")) {
			return facultyRequestRepo.findByStatusNotOrderByCreatedDateAsc("Resolved");
		}
		throw new ResourceRequestNotAccessibleException("You cannot access this resource!");
	}

	@Override
	public FacultyRequest setResolved(String requestId, HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String defaultId = userClient.getUserId(assignedToDefault);
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		if (defaultId.equals(id) || userType.equals("head")) {
			if (facultyRequestRepo.findById(requestId).isPresent()) {
				FacultyRequest existingRequest = facultyRequestRepo.findById(requestId).get();
				existingRequest.setStatus("Resolved");
				existingRequest.setModifiedBy(id);
				existingRequest.setModifiedDate(simpleDateFormat.format(new Date()));
				FacultyRequest updatedRequest = facultyRequestRepo.save(existingRequest);
				return updatedRequest;
			}
			throw new ResourceRequestNotFoundException("Resource not found");
		}
		throw new ResourceRequestNotAccessibleException("You cannot access this resource!");
	}
}
