package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.model.CWNComplaint;
import sgsits.cse.dis.administration.repo.CWNComplaintRepository;
import sgsits.cse.dis.administration.service.CwnComplaintService;

@Service
public class CwnComplaintServiceImpl implements CwnComplaintService {

	@Autowired
	CWNComplaintRepository cwnComplaintRepository;
	
	@Autowired
	private InfrastructureClient infrastructureClient;

	@Override
	public List<CWNComplaint> getResolvedComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return cwnComplaintRepository.findByLocationInAndStatus(location, "Resolved");
		return null;
	}

	@Override
	public List<CWNComplaint> getTotalComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return cwnComplaintRepository.findByLocationIn(location);
		return null;
	}
	
}
