package sgsits.cse.dis.administration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.model.CleanlinessComplaint;
import sgsits.cse.dis.administration.repo.CleanlinessComplaintRepository;
import sgsits.cse.dis.administration.service.CleanlinessComplaintService;

@Service
public class CleanlinessComplaintServiceImpl implements CleanlinessComplaintService {

	@Autowired
	CleanlinessComplaintRepository cleanlinessComplaintRepository;
	
	@Autowired
	private InfrastructureClient infrastructureClient;
	
	@Override
	public List<CleanlinessComplaint> getMyComplaints(String userId) {
		return cleanlinessComplaintRepository.findByCreatedBy(userId);
	}

	@Override
	public List<CleanlinessComplaint> getResolvedComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return cleanlinessComplaintRepository.findByLocationInAndStatus(location, "Resolved");
		return null;
	}

}
