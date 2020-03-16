package sgsits.cse.dis.administration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.FacultyComplaint;
import sgsits.cse.dis.administration.repo.FacultyComplaintRepository;
import sgsits.cse.dis.administration.service.FacultyComplaintService;

@Service
public class FacultyServiceImpl implements FacultyComplaintService{
	@Autowired
	FacultyComplaintRepository facultyComplaintRepository;

	@Override
	public List<FacultyComplaint> getRemainingFacultyComplaints() {
		return facultyComplaintRepository.findByStatusNot("Resolved");
	}

	@Override
	public List<FacultyComplaint> getMyComplaints(String userId) {
		return facultyComplaintRepository.findByCreatedBy(userId);
	}
	
	

	
}
