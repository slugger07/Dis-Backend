package sgsits.cse.dis.administration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.administration.model.CleanlinessComplaint;
import sgsits.cse.dis.administration.repo.CleanlinessComplaintRepository;
import sgsits.cse.dis.administration.service.CleanlinessComplaintService;

@Component
public class CleanlinessComplaintServiceImpl implements CleanlinessComplaintService {

	@Autowired
	CleanlinessComplaintRepository cleanlinessComplaintRepository;
	
	@Override
	public List<CleanlinessComplaint> getAllCleanlinessComplaints(List<String> locations) {
		return cleanlinessComplaintRepository.findByLocationInAndStatusNot(locations, "Resolved");
	}
	
}
