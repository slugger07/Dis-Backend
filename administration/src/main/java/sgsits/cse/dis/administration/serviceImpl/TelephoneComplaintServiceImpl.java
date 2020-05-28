package sgsits.cse.dis.administration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.model.TelephoneComplaint;
import sgsits.cse.dis.administration.repo.TelephoneComplaintRepository;
import sgsits.cse.dis.administration.service.TelephoneComplaintService;

public class TelephoneComplaintServiceImpl implements TelephoneComplaintService {
	
	@Autowired
	private InfrastructureClient infrastructureClient;
	
	@Autowired
	private TelephoneComplaintRepository telephoneComplaintRepository;

	@Override
	public List<TelephoneComplaint> getResolvedComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return telephoneComplaintRepository.findByLocationInAndStatus(location, "Resolved");
		return null;
	}
	
}
