package sgsits.cse.dis.administration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.StudentComplaint;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.request.StudentComplaintForm;

@Service
public interface StudentComplaintService {
	public List<StudentComplaint> getRemainingStudentComplaints();
	boolean existsByCreatedByAndRollNoAndNameAndYearAndStatusNot(String userId, String rollNo, String studentName, String year, String status);
	boolean existsByCreatedByAndRollNoAndYearAndStatusNot(String userId, String rollNo, String year, String status);
	boolean existsByCreatedByAndNameAndYearAndStatusNot(String userId, String studentName, String year, String status);
	StudentComplaint addComplaint(StudentComplaintForm complaintForm, String userId);
	StudentComplaint editComplaint(EditComplaintForm complaintForm, String userId);
	long countByStatusNot(String status);
	long countByStatus(String status);
	long countByCreatedBy(String userId);
	long countAll();
	public List<StudentComplaint> findAll();
	public List<StudentComplaint> getMyComplaints(String userType, String id);
	public List<StudentComplaint> getResolvedComplaints(String userType, String id);
}
