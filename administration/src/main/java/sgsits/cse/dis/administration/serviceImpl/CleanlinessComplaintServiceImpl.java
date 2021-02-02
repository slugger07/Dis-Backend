package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.model.CleanlinessComplaint;
import sgsits.cse.dis.administration.repo.CleanlinessComplaintRepository;
import sgsits.cse.dis.administration.request.CleanlinessComplaintForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.service.CleanlinessComplaintService;

@Service
public class CleanlinessComplaintServiceImpl implements CleanlinessComplaintService {

	@Autowired
	CleanlinessComplaintRepository cleanlinessComplaintRepository;
	
	@Autowired
	private InfrastructureClient infrastructureClient;
	
	@Override
	public List<CleanlinessComplaint> findAllRemainingComplaints(List<String> location) {
		return cleanlinessComplaintRepository.findByLocationInAndStatusNot(location, "Resolved");
	}

	@Override
	public CleanlinessComplaint addComplaint(CleanlinessComplaintForm complaintForm, String userId) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		CleanlinessComplaint test = null;
		CleanlinessComplaint cleanlinessComplaint = new CleanlinessComplaint();
		cleanlinessComplaint.setDetails(complaintForm.getDetails());
		cleanlinessComplaint.setLocation(complaintForm.getLocation());
		cleanlinessComplaint.setLevelOfDust(complaintForm.getLevelOfDust());
		cleanlinessComplaint.setCreatedBy(userId);
		cleanlinessComplaint.setCreatedDate(simpleDateFormat.format(new Date()));
		cleanlinessComplaint.setStatus("Not Resolved");
		cleanlinessComplaint.setType("CLEANLINESS");
		test = cleanlinessComplaintRepository.save(cleanlinessComplaint);
		return test;
	}

	@Override
	public boolean checkIfComplaintExist(String userId, String location, String status) {
		if (cleanlinessComplaintRepository.existsByCreatedByAndLocationAndStatusNot(userId, location, status)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public CleanlinessComplaint editComplaint(EditComplaintForm complaintForm, String userId) {
		Optional<CleanlinessComplaint> cc = cleanlinessComplaintRepository.findById(complaintForm.getId());
		if (cc.isPresent()) {
			cc.get().setModifiedBy(userId);
			cc.get().setModifiedDate((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
			cc.get().setStatus(complaintForm.getStatus());
			cc.get().setRemarks(complaintForm.getRemarks());
			if(complaintForm.getStatus().equals("Resolved")) {
				cc.get().setDateOfResolution((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
		}	}
			CleanlinessComplaint test = cleanlinessComplaintRepository.save(cc.get());
			return test;
	}

	@Override
	public long count() {
		long count = cleanlinessComplaintRepository.countByLocationAndStatusNot("General Computing Lab", "Resolved");
		count += cleanlinessComplaintRepository.countByLocationAndStatusNot("SG Lab", "Resolved");
		return count;
	}

	@Override
	public long countIn() {
		List<String> locations = new ArrayList<>();
		locations.add("General Computing Lab");
		locations.add("SG Lab");
		return cleanlinessComplaintRepository.countByLocationInAndStatusNot(locations, "Resolved");
	}

	@Override
	public long countByLocationInAndStatusNot(List<String> locations, String status) {
		return cleanlinessComplaintRepository.countByLocationInAndStatusNot(locations, "Resolved");
	}

	@Override
	public long countByLocationInAndStatus(List<String> locations, String status) {
		return cleanlinessComplaintRepository.countByLocationInAndStatus(locations, "Resolved");
	}

	@Override
	public long countByLocationIn(List<String> loctions) {
		return cleanlinessComplaintRepository.countByLocationIn(loctions);
	}

	@Override
	public long countByCreatedBy(String userId) {
		return cleanlinessComplaintRepository.countByCreatedBy(userId);
	}

	@Override
	public List<CleanlinessComplaint> findByLocationIn(List<String> location) {
		return cleanlinessComplaintRepository.findByLocationIn(location);
	}	
	
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
