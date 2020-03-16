package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.EMRComplaint;
import sgsits.cse.dis.administration.repo.EMRComplaintRepository;
import sgsits.cse.dis.administration.request.EMRComplaintForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.service.EMRComplaintService;

@Service
public class EmrComplaintServiceImpl implements EMRComplaintService {

	@Autowired
	EMRComplaintRepository emrsComplaintRepository;

	@Override
	public List<EMRComplaint> findAllRemainingComplaints(List<String> location) {
		return emrsComplaintRepository.findByLocationInAndStatusNot(location, "Resolved");
	}

	@Override
	public List<EMRComplaint> addMultipleComplaint(List<EMRComplaintForm> emrComplaints, String userId) {
		/*
		 * long formId = emrsComplaintRepository.maxOfFormId(); int size =
		 * emrsComplaintForm.size(); int count = 0;
		 */
		List<EMRComplaint> complaintList = new ArrayList<EMRComplaint>();
		for (EMRComplaintForm complaint : emrComplaints) {
			if (!emrsComplaintRepository.existsByLocationAndDetailsAndStatusNot(complaint.getLocation(),
					complaint.getDetails(), "Resolved")) {
				EMRComplaint emrComplaint = new EMRComplaint();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				emrComplaint.setStatus("Not Resolved");
				emrComplaint.setCreatedBy(userId);
				emrComplaint.setCreatedDate(simpleDateFormat.format(new Date()));
				emrComplaint.setLocation(complaint.getLocation());
				emrComplaint.setDetails(complaint.getDetails());
				complaintList.add(emrComplaint);
			}
		}
		List<EMRComplaint> test = emrsComplaintRepository.saveAll(complaintList);
		return test;

	}

	@Override
	public EMRComplaint editComplaint(EditComplaintForm editComplaintForm, String userId) {
		Optional<EMRComplaint> emrs = emrsComplaintRepository.findById(editComplaintForm.getId());
		EMRComplaint test = null;
		if (emrs.isPresent()) {
			emrs.get().setModifiedBy(userId);
			emrs.get().setModifiedDate((new SimpleDateFormat()).format(new Date()));
			emrs.get().setStatus(editComplaintForm.getStatus());
			emrs.get().setRemarks(editComplaintForm.getRemarks());
			if (editComplaintForm.getStatus().equals("Resolved"))
				emrs.get().setDateOfResolution((new SimpleDateFormat()).format(new Date()));
			test = emrsComplaintRepository.save(emrs.get());
		}
		return test;
	}

}
