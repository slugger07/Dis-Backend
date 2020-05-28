package sgsits.cse.dis.administration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.model.ECCWComplaint;
import sgsits.cse.dis.administration.repo.ECCWComplaintRepository;
import sgsits.cse.dis.administration.service.EccwComplaintService;

@Service
public class EccwComplaintServiceImpl implements EccwComplaintService {
	
	@Autowired
	ECCWComplaintRepository eccwComplaintRepository;
	
	@Autowired
	private InfrastructureClient infrastructureClient;
	
	@Override
	public List<ECCWComplaint> getResolvedComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return eccwComplaintRepository.findByLocationInAndStatus(location, "Resolved");
		return null;
	}

}
