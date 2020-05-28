package sgsits.cse.dis.administration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.model.EMRComplaint;
import sgsits.cse.dis.administration.repo.EMRComplaintRepository;
import sgsits.cse.dis.administration.service.EmrComplaintService;

@Service
public class EmrComplaintServiceImpl implements EmrComplaintService {

	@Autowired
	EMRComplaintRepository emrsComplaintRepository;
	
	@Autowired
	private InfrastructureClient infrastructureClient;

	@Override
	public List<EMRComplaint> getResolvedComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return emrsComplaintRepository.findByLocationInAndStatus(location, "Resolved");
		return null;
	}

}
