package sgsits.cse.dis.administration.serviceImpl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.exception.ConflictException;
import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.model.FacultyResourceRequest;
import sgsits.cse.dis.administration.repo.FacultyResourceRequestRepository;
import sgsits.cse.dis.administration.request.FacultyResourceRequestForm;
import sgsits.cse.dis.administration.service.ResourceRequestServices;

@Service
public class ResourceRequestServicesImpl implements ResourceRequestServices,Serializable {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private FacultyResourceRequestRepository facultyResourceRequestRepository;
	
	public String addFacultyResourceRequest(FacultyResourceRequestForm facultyResourceRequestForm, String userId) throws ConflictException 
	{
		
		FacultyResourceRequest test = facultyResourceRequestRepository.save(new FacultyResourceRequest(
				userId, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()),
				facultyResourceRequestForm.getResourceCategory(),
				facultyResourceRequestForm.getDetails(),
				facultyResourceRequestForm.getPriority(),
				facultyResourceRequestForm.getDeadlineOfResolution(),
				"In progress"
				));
	
		if(test.equals(null))
			throw new ConflictException("Resource request could not be added. This is due to conflict in information on client side.");
		
		return "Resource request added successfully.";
	}
	
	public List<FacultyResourceRequest> showFacultyResourceRequest (String status) throws EventDoesNotExistException
	{
	     List<FacultyResourceRequest> test = facultyResourceRequestRepository.getFacultyResourceRequestByStatus(status);
		 
		 if(test.isEmpty())
			 throw new EventDoesNotExistException("No faculty resource request exists.");
		 
		 	return test;
	}
	
	public List<FacultyResourceRequest> searchFacultyResourceRequestByPriority (String priority) throws EventDoesNotExistException
	{
		List<FacultyResourceRequest> test = facultyResourceRequestRepository.findByPriorityContainingIgnoreCase(priority);
		
		if(test.isEmpty())
			throw new EventDoesNotExistException("No faculty resource request exists.");
		
			return test;
	}
}
