package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.exception.ResourceRequestNotAccessibleException;
import sgsits.cse.dis.administration.exception.ResourceRequestNotFoundException;
import sgsits.cse.dis.administration.feignClient.GatewayClient;
import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.jwt.JwtResolver;
import sgsits.cse.dis.administration.model.FacultyRequest;
import sgsits.cse.dis.administration.repo.FacultyRequestRepo;
import sgsits.cse.dis.administration.request.FacultyRequestForm;
import sgsits.cse.dis.administration.service.FacultyRequestService;

@Service
public class FacultyRequestServiceImpl implements FacultyRequestService {
	
	@Autowired
	private GatewayClient gatewayClient;
	
	@Autowired
	private InfrastructureClient infrastructureClient;
	
	@Autowired
	private FacultyRequestRepo facultyRequestRepo;
	
	private static String assignedToDefault = "pbamne"; 
	private static String assignedToDefaultId = "a3cf9b06-20b1-11ea-bbd9-acd1b8c931f7";
	
	JwtResolver jwtResolver = new JwtResolver();

	@Override
	public FacultyRequest addRequest(FacultyRequestForm facultyRequestForm, HttpServletRequest request) {
		String createdById = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		FacultyRequest facultyRequest = new FacultyRequest();
		facultyRequest.setCreatedBy(createdById);
		facultyRequest.setCategory(facultyRequestForm.getCategory());
		facultyRequest.setCreatedDate(simpleDateFormat.format(new Date()));
		System.out.println(gatewayClient.getUserId(assignedToDefault));
		facultyRequest.setAssignedPersonId(assignedToDefaultId);
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
	
	
}
