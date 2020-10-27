package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.model.LEComplaint;
import sgsits.cse.dis.administration.repo.LEComplaintRepository;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.request.LEComplaintForm;
import sgsits.cse.dis.administration.service.LEComplaintService;

@Service
public class LEComplaintServiceImpl implements LEComplaintService{

	@Autowired
	LEComplaintRepository leComplaintRepository;
	
	@Autowired
	private InfrastructureClient infrastructureClient;
	
	@Override
	public List<LEComplaint> getMyComplaints(String userId) {
		return leComplaintRepository.findByCreatedBy(userId);
	}

	@Override
	public LEComplaint addComplaint(LEComplaintForm complaintForm, String userId) {
		LEComplaint leComplaint = new LEComplaint();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		leComplaint.setCreatedBy(userId);
		leComplaint.setCreatedDate(simpleDateFormat.format(new Date()));
		leComplaint.setStatus("Not Assigned");
		leComplaint.setLab(complaintForm.getLab());
		leComplaint.setSystemNo(complaintForm.getSystemNo());
		leComplaint.setDetails(complaintForm.getDetails());
		leComplaint.setType("LE");
		LEComplaint test = leComplaintRepository.save(leComplaint);
		return test;
	}

	@Override
	public boolean checkIfComplaintExist(String id, String lab, String systemNo, String status) {
		if(!leComplaintRepository.existsByCreatedByAndLabAndSystemNoAndStatusNot(id, lab, systemNo, "Resolved")) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public LEComplaint editComplaint(EditComplaintForm editComplaintForm, String userId) {
		LEComplaint test = null;
		Optional<LEComplaint> lec = leComplaintRepository.findById(editComplaintForm.getId());
		if (lec.isPresent()) {
			lec.get().setModifiedBy(userId);
			lec.get().setModifiedDate((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
			lec.get().setStatus(editComplaintForm.getStatus());
			lec.get().setRemarks(editComplaintForm.getRemarks());
			if(editComplaintForm.getStatus().equals("Resolved"))
				lec.get().setDateOfResolution((new SimpleDateFormat()).format(new Date()));
			test = leComplaintRepository.save(lec.get());
		}
		return test;
	}

	@Override
	public long countByLabInAndStatusNot(List<String> locations, String status) {
		return leComplaintRepository.countByLabInAndStatusNot(locations, "Resolved");
	}

	@Override
	public long countByLabInAndStatus(List<String> locations, String status) {
		return leComplaintRepository.countByLabInAndStatus(locations, "Resolved");
	}

	@Override
	public long countByLabIn(List<String> locations) {
		return leComplaintRepository.countByLabIn(locations);
	}

	@Override
	public long countByCreatedBy(String userId) {
		return leComplaintRepository.countByCreatedBy(userId);
	}

	@Override
	public List<LEComplaint> findByLabIn(List<String> location) {
		return leComplaintRepository.findByLabIn(location);
	}

	public List<LEComplaint> getResolvedComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return leComplaintRepository.findByLabInAndStatus(location, "Resolved");
		return null;
	}

	@Override
	public List<LEComplaint> findAllRemainingComplaints(List<String> location) {
		return leComplaintRepository.findByLabInAndStatusNot(location, "Resolved");
	}
	
	
}
