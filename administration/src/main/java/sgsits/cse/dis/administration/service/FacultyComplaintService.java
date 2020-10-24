package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.model.FacultyComplaint;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.request.FacultyComplaintForm;

public interface FacultyComplaintService {
	public List<FacultyComplaint> getRemainingFacultyComplaints();
	FacultyComplaint addComplaint(FacultyComplaintForm complaintsList, String userId);
	FacultyComplaint editComplaint(EditComplaintForm complaintForm, String userId);
	long countByStatusNot(String status);
	long countByStatus(String status);
	long countByCreatedBy(String userId);
	long countAll();
	public List<FacultyComplaint> findAll();
	public List<FacultyComplaint> getResolvedComplaints(String userType, String id);
	public List<FacultyComplaint> getMyComplaints(String userType, String userId);
}
