package sgsits.cse.dis.administration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.StudentComplaint;
import sgsits.cse.dis.administration.repo.StudentComplaintRepository;
import sgsits.cse.dis.administration.service.StudentComplaintService;

@Service
public class StudentComplaintServiceImpl implements StudentComplaintService{
	@Autowired
	StudentComplaintRepository studentComplaintRepository;
	
	@Override
	public List<StudentComplaint> getRemainingStudentComplaints() {
		return studentComplaintRepository.findByStatusNot("Resolved");
	}

	@Override
	public List<StudentComplaint> getMyStudentComplaints(String userId) {
		return studentComplaintRepository.findByCreatedBy(userId);
	}
	
}
