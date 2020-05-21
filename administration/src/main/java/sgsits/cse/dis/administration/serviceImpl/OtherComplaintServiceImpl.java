package sgsits.cse.dis.administration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.OtherComplaint;
import sgsits.cse.dis.administration.repo.OtherComplaintRepository;
import sgsits.cse.dis.administration.service.OtherComplaintService;

@Service
public class OtherComplaintServiceImpl implements OtherComplaintService {
	
	@Autowired
	OtherComplaintRepository otherComplaintRepository;

	@Override
	public List<OtherComplaint> getMyComplaints(String userId) {
		return otherComplaintRepository.findByCreatedBy(userId);
	}

	@Override
	public List<OtherComplaint> getResolvedComplaints(String userType, String id) {
		if (userType.equals("head")) 
			return otherComplaintRepository.findByStatus("Resolved");
		return otherComplaintRepository.findByAssignedToAndStatus(id, "Resolved");
	}

}
