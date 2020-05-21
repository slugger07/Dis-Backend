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
	public List<StudentComplaint> getMyComplaints(String userType, String userId) {
		if (userType.contentEquals("faculty"))
			return studentComplaintRepository.findByCreatedBy(userId);
		return null;
	}

	@Override
	public List<StudentComplaint> getResolvedComplaints(String userType, String id) {
		if (userType.equals("head")) 
			return studentComplaintRepository.findByStatus("Resolved");
		return null;
	}
	
}
