package sgsits.cse.dis.administration.service;

import sgsits.cse.dis.administration.exception.ConflictException;
import sgsits.cse.dis.administration.request.FacultyResourceRequestForm;

public interface ResourceRequestServices {
	
	public String addFacultyResourceRequest(FacultyResourceRequestForm facultyResourceRequestForm, String userId) throws ConflictException;

}
