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
import sgsits.cse.dis.administration.request.ComplaintDownloadReportForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.request.TelephoneComplaintForm;
import sgsits.cse.dis.administration.response.TelephoneComplaintResponse;
import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.service.TelephoneComplaintService;

@Service
public class TelephoneComplaintServiceImpl implements TelephoneComplaintService {

	@Autowired
	TelephoneComplaintRepository telephoneComplaintRepository;
	
	@Autowired
	private InfrastructureClient infrastructureClient;
	
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
				telephoneComplaint.setType("TELEPHONE");
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
			tc.get().setModifiedDate((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
			tc.get().setStatus(editComplaintForm.getStatus());
			tc.get().setRemarks(editComplaintForm.getRemarks());
			if (editComplaintForm.getStatus().equals("Resolved"))
				tc.get().setDateOfResolution((new SimpleDateFormat()).format(new Date()));
			test = telephoneComplaintRepository.save(tc.get());

		}
		return test;
	}

	@Override
	public long countByLocationInAndStatusNot(List<String> locations, String status) {
		return telephoneComplaintRepository.countByLocationInAndStatusNot(locations, "Resolved");
	}

	@Override
	public long countByLocationInAndStatus(List<String> locations, String status) {
		return telephoneComplaintRepository.countByLocationInAndStatus(locations, status);
	}

	@Override
	public long countByLocationIn(List<String> loctions) {
		return telephoneComplaintRepository.countByLocationIn(loctions);
	}

	@Override
	public List<TelephoneComplaintResponse> getDownloadReportData(ComplaintDownloadReportForm complaintInfo) {
		Optional<List<TelephoneComplaint>> telephones = null;
		List<TelephoneComplaintResponse> complaints = new ArrayList<>();
		if(complaintInfo.getLocation().equals("")) {
			telephones = telephoneComplaintRepository.findByCreatedDate(complaintInfo.getCreatedDate());
		}
		else {
			telephones = telephoneComplaintRepository.findByCreatedDateAndLocation(complaintInfo.getCreatedDate(), complaintInfo.getLocation());
		}
		if(telephones.isPresent()) {
			int count = 1;
			for(TelephoneComplaint telephoneComplaint : telephones.get()) {
				TelephoneComplaintResponse complaint = new TelephoneComplaintResponse();
				complaint.setDetails(telephoneComplaint.getDetails());
				complaint.setLocation(telephoneComplaint.getLocation());
				complaint.setExtensionNo(telephoneComplaint.getExtensionNo());
				complaint.setDateOfResolution(telephoneComplaint.getDateOfResolution());
				complaint.setCreatedDate(telephoneComplaint.getCreatedDate());
				complaint.setSno(count);
				complaints.add(complaint);
				count++;
			}
		}
		return complaints;
	}

	@Override
	public List<TelephoneComplaint> findAllRemainingComplaints(List<String> location) {
		return telephoneComplaintRepository.findByLocationInAndStatusNot(location, "Resolved");
	}


	@Override
	public List<TelephoneComplaint> getResolvedComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return telephoneComplaintRepository.findByLocationInAndStatus(location, "Resolved");
		return null;
	}

	@Override
	public List<TelephoneComplaint> getTotalComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return telephoneComplaintRepository.findByLocationIn(location);
		return null;
	}

	@Override
	public List<TelephoneComplaint> getRemainingComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return telephoneComplaintRepository.findByLocationInAndStatusNot(location, "Resolved");
		return null;
	}
	
}
