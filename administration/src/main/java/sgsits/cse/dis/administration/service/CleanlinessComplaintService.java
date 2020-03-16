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
}
