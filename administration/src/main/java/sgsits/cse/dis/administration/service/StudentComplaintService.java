package sgsits.cse.dis.administration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.StudentComplaint;

@Service
public interface StudentComplaintService {
	public List<StudentComplaint> getRemainingStudentComplaints();
	public List<StudentComplaint> getMyStudentComplaints(String id);
}
