package sgsits.cse.dis.administration.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import sgsits.cse.dis.administration.model.FacultyRequest;
import sgsits.cse.dis.administration.request.FacultyRequestForm;

public interface FacultyRequestService {
	
	FacultyRequest addRequest(FacultyRequestForm facultyRequestForm, HttpServletRequest request);
	Optional<FacultyRequest> getRequest(String requestId, HttpServletRequest request);
}
