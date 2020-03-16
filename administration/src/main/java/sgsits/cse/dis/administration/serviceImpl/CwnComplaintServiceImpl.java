package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.CWNComplaint;
import sgsits.cse.dis.administration.repo.CWNComplaintRepository;
import sgsits.cse.dis.administration.request.CWNComplaintForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.service.CWNComplaintService;

@Service
public class CwnComplaintServiceImpl implements CWNComplaintService {

	@Autowired
	CWNComplaintRepository cwnComplaintRepository;

	@Override
	public List<CWNComplaint> findAllRemainingComplaints(List<String> location) {
		return cwnComplaintRepository.findByLocationInAndStatusNot(location, "Resolved");
	}

	@Override
	public List<CWNComplaint> addMutipleComplaints(List<CWNComplaintForm> complaintForm, String userId) {
		// long formId = cwnComplaintRepository.maxOfFormId();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		/*
		 * int size = complaintForm.size(); int count=0;
		 */
		List<CWNComplaint> complaintList = new ArrayList<>();
		for (CWNComplaintForm complaint : complaintForm) {
			if (!cwnComplaintRepository.existsByLocationAndDetailsAndStatusNot(complaint.getLocation(),
					complaint.getDetails(), "Resolved")) {
				CWNComplaint cwnComplaint = new CWNComplaint();
				cwnComplaint.setStatus("Not Resolved");
				cwnComplaint.setCreatedBy(userId);
				cwnComplaint.setCreatedDate(simpleDateFormat.format(new Date()));
				cwnComplaint.setLocation(complaint.getLocation());
				cwnComplaint.setDetails(complaint.getDetails());
				complaintList.add(cwnComplaint);
				// count++;
			}
		}
		/*
		 * if(count == size) {
		 * 
		 * }
		 */
		List<CWNComplaint> test = cwnComplaintRepository.saveAll(complaintList);
		return test;
	}

	@Override
	public CWNComplaint editComplaint(EditComplaintForm editComplaintForm, String userId) {
		Optional<CWNComplaint> cwn = cwnComplaintRepository.findById(editComplaintForm.getId());
		CWNComplaint test = null;
		if (cwn.isPresent()) {
			cwn.get().setModifiedBy(userId);
			cwn.get().setModifiedDate((new SimpleDateFormat()).format(new Date()));
			cwn.get().setStatus(editComplaintForm.getStatus());
			cwn.get().setRemarks(editComplaintForm.getRemarks());
			if (editComplaintForm.getStatus().equals("Resolved"))
				cwn.get().setDateOfResolution((new SimpleDateFormat()).format(new Date()));
			test = cwnComplaintRepository.save(cwn.get());
		}
		return test;
	}

}
