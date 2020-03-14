package sgsits.cse.dis.administration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.LEComplaint;
import sgsits.cse.dis.administration.repo.LEComplaintRepository;
import sgsits.cse.dis.administration.service.ComplaintService;

@Service
public class LeComplaintServiceImpl implements ComplaintService<LEComplaint> {

	@Autowired
	LEComplaintRepository leComplaintRepository;
	
	@Override
	public List<LEComplaint> findAllRemainingComplaints(List<String> location) {
		return leComplaintRepository.findByLabInAndStatusNot(location, "Resolved");
	}

	@Override
	public LEComplaint addComplaint(LEComplaint complaintForm, String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
