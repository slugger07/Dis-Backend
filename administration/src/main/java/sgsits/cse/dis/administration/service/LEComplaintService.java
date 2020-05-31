package sgsits.cse.dis.administration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.LEComplaint;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.request.LEComplaintForm;

@Service
public interface LEComplaintService{
	boolean checkIfComplaintExist(String id, String lab, String systemNo, String status);
	List<LEComplaint> findAllRemainingComplaints(List<String> location);
	LEComplaint addComplaint(LEComplaintForm complaintForm, String userId);
	LEComplaint editComplaint(EditComplaintForm complaintForm, String userId);	
	long countByLabInAndStatusNot(List<String> locations, String status);
	long countByLabInAndStatus(List<String> locations, String status);
	long countByLabIn(List<String> locations);
	long countByCreatedBy(String userId);
	List<LEComplaint> findByLabIn(List<String> location);
	public List<LEComplaint> getMyComplaints(String id);
	public List<LEComplaint> getResolvedComplaints(String id);
}
