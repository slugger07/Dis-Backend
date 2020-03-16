package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.CleanlinessComplaint;
import sgsits.cse.dis.administration.repo.CleanlinessComplaintRepository;
import sgsits.cse.dis.administration.request.CleanlinessComplaintForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.service.CleanlinessComplaintService;

@Service
public class CleanlinessComplaintServiceImpl implements CleanlinessComplaintService {

	@Autowired
	CleanlinessComplaintRepository cleanlinessComplaintRepository;

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
}
