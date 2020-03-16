package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.TelephoneComplaint;
import sgsits.cse.dis.administration.repo.TelephoneComplaintRepository;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.request.TelephoneComplaintForm;
import sgsits.cse.dis.administration.service.TelephoneComplaintService;

@Service
public class TelephoneComplaintServiceImpl implements TelephoneComplaintService {

	@Autowired
	TelephoneComplaintRepository telephoneComplaintRepository;

	@Override
	public List<TelephoneComplaint> addMultipleComplaint(List<TelephoneComplaintForm> complaintList, String userId) {
		/*
		 * long formId = telephoneComplaintRepository.maxOfFormId(); int size =
		 * telephoneComplaintForm.size(); int count = 0;
		 */
		List<TelephoneComplaint> telephoneComplaints = new ArrayList<>();
		for (TelephoneComplaintForm complaint : complaintList) {
			if (!telephoneComplaintRepository.existsByExtensionNoAndLocationAndDetailsAndStatusNot(
					complaint.getExtensionNo(), complaint.getLocation(), complaint.getDetails(), "Resolved")) {
				TelephoneComplaint telephoneComplaint = new TelephoneComplaint();
				telephoneComplaint.setCreatedBy(userId);
				telephoneComplaint.setCreatedDate((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
				telephoneComplaint.setStatus("Not Assigned");
				telephoneComplaint.setLocation(complaint.getLocation());
				telephoneComplaint.setDetails(complaint.getDetails());
				telephoneComplaint.setExtensionNo(complaint.getExtensionNo());
				telephoneComplaints.add(telephoneComplaint);
			}
		}
		List<TelephoneComplaint> test = telephoneComplaintRepository.saveAll(telephoneComplaints);
		return test;

	}

	@Override
	public TelephoneComplaint editComplaint(EditComplaintForm editComplaintForm, String userId) {
		Optional<TelephoneComplaint> tc = telephoneComplaintRepository.findById(editComplaintForm.getId());
		TelephoneComplaint test = null;
		if (tc.isPresent()) {
			tc.get().setModifiedBy(userId);
			tc.get().setModifiedDate((new SimpleDateFormat()).format(new Date()));
			tc.get().setStatus(editComplaintForm.getStatus());
			tc.get().setRemarks(editComplaintForm.getRemarks());
			if (editComplaintForm.getStatus().equals("Resolved"))
				tc.get().setDateOfResolution((new SimpleDateFormat()).format(new Date()));
			test = telephoneComplaintRepository.save(tc.get());

		}
		return test;
	}
}
