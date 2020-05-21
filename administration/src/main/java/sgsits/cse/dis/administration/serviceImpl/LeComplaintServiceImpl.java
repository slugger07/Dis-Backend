package sgsits.cse.dis.administration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.model.LEComplaint;
import sgsits.cse.dis.administration.repo.LEComplaintRepository;
import sgsits.cse.dis.administration.service.LEComplaintService;

@Service
public class LeComplaintServiceImpl implements LEComplaintService{

	@Autowired
	LEComplaintRepository leComplaintRepository;
	
	@Autowired
	private InfrastructureClient infrastructureClient;
	
	@Override
	public List<LEComplaint> getMyComplaints(String userId) {
		return leComplaintRepository.findByCreatedBy(userId);
	}

	@Override
	public List<LEComplaint> getResolvedComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return leComplaintRepository.findByLabInAndStatus(location, "Resolved");
		return null;
	}
	
	
}
