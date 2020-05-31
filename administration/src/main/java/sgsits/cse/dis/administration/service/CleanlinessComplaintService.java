package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.model.CleanlinessComplaint;
import sgsits.cse.dis.administration.request.CleanlinessComplaintForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;

public interface CleanlinessComplaintService{
	boolean checkIfComplaintExist(String userId, String location, String status);
	List<CleanlinessComplaint> findAllRemainingComplaints(List<String> location);
	CleanlinessComplaint addComplaint(CleanlinessComplaintForm complaintForm, String userId);
	CleanlinessComplaint editComplaint(EditComplaintForm complaintForm, String userId);
	long count();
	long countIn();
	long countByLocationInAndStatusNot(List<String> locations, String status);
	long countByLocationInAndStatus(List<String> locations, String status);
	long countByLocationIn(List<String> loctions);
	long countByCreatedBy(String userId);
	List<CleanlinessComplaint> findByLocationIn(List<String> location);
	List<CleanlinessComplaint> getMyComplaints(String id);
	List<CleanlinessComplaint> getResolvedComplaints(String id);
}
