package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.exception.ConflictException;
import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.model.FacultyResourceRequest;
import sgsits.cse.dis.administration.request.FacultyResourceRequestForm;

public interface ResourceRequestServices {
	
	String addFacultyResourceRequest(FacultyResourceRequestForm facultyResourceRequestForm, String userId) throws ConflictException;

	List<FacultyResourceRequest> showFacultyResourceRequest (String status) throws EventDoesNotExistException;
	
	List<FacultyResourceRequest> searchFacultyResourceRequestByPriority (String priority) throws EventDoesNotExistException;
}
