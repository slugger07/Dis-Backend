package sgsits.cse.dis.administration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.administration.model.CleanlinessComplaint;
import sgsits.cse.dis.administration.repo.CleanlinessComplaintRepository;
import sgsits.cse.dis.administration.service.ComplaintService;

@Component
public class CleanlinessComplaintServiceImpl implements ComplaintService<CleanlinessComplaint>{

	@Autowired
	CleanlinessComplaintRepository cleanlinessComplaintRepository;
	
	@Override
	public List<CleanlinessComplaint> findAllRemainingComplaints(List<String> location) {
		System.out.println(location);
		return cleanlinessComplaintRepository.findByLocationInAndStatusNot(location, "Resolved");
	}

}
