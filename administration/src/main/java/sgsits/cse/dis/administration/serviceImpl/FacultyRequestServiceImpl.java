package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		FacultyRequest facultyRequest = new FacultyRequest();
		facultyRequest.setCreatedBy(createdById);
		facultyRequest.setCategory(facultyRequestForm.getCategory());
		facultyRequest.setCreatedDate(simpleDateFormat.format(new Date()));
		facultyRequest.setAssignedPersonId(userClient.getUserId(assignedToDefault));
//		getting the ID of the assignedToDefault person from the feign client of user service.
		FacultyRequest result = facultyRequestRepo.save(facultyRequest);
		return result;
	}
	
	@Override
	public Optional<FacultyRequest> getRequest(String requestId, HttpServletRequest request) {
		String userType = jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization"));
		Optional<FacultyRequest> resourceRequest = null;
		if (!userType.contentEquals("student")) {
			resourceRequest = facultyRequestRepo.findById(requestId);
			if (!resourceRequest.isPresent()) throw new ResourceRequestNotFoundException("Resource not found");
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
}
