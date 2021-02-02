package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.model.CWNComplaint;
import sgsits.cse.dis.administration.repo.CWNComplaintRepository;
import sgsits.cse.dis.administration.request.CWNComplaintForm;
import sgsits.cse.dis.administration.request.ComplaintDownloadReportForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.response.ComplaintGeneralResponse;

import sgsits.cse.dis.administration.service.CWNComplaintService;

@Service
public class CWNComplaintServiceImpl implements CWNComplaintService {

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
				cwnComplaint.setType("CWN");
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
			cwn.get().setModifiedDate((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
			cwn.get().setStatus(editComplaintForm.getStatus());
			cwn.get().setRemarks(editComplaintForm.getRemarks());
			if (editComplaintForm.getStatus().equals("Resolved"))
				cwn.get().setDateOfResolution((new SimpleDateFormat()).format(new Date()));
			test = cwnComplaintRepository.save(cwn.get());
		}
		return test;
	}

	@Override
	public long countByLocationInAndStatusNot(List<String> locations, String status) {
		return cwnComplaintRepository.countByLocationInAndStatusNot(locations, "Resolved");
	}

	@Override
	public long countByLocationInAndStatus(List<String> locations, String status) {
		return cwnComplaintRepository.countByLocationInAndStatus(locations, "Resolved");
	}

	@Override
	public long countByLocationIn(List<String> loctions) {
		return cwnComplaintRepository.countByLocationIn(loctions);
	}

	@Override
	public List<ComplaintGeneralResponse> getDownloadReportData(ComplaintDownloadReportForm complaintInfo) {
		Optional<List<CWNComplaint>> cwns = null;
		if(complaintInfo.getLocation().equals("")) {
			cwns = cwnComplaintRepository.findByCreatedDate(complaintInfo.getCreatedDate());
		}
		else {
			cwns = cwnComplaintRepository.findByCreatedDateAndLocation(complaintInfo.getCreatedDate(), complaintInfo.getLocation());
		}
		List<ComplaintGeneralResponse> complaints = new ArrayList<>();
		if(cwns.isPresent()) {
			int count = 1;
			for(CWNComplaint cwn : cwns.get()) {
				ComplaintGeneralResponse complaint = new ComplaintGeneralResponse();
				complaint.setDetails(cwn.getDetails());
				complaint.setLocation(cwn.getLocation());
				complaint.setSno(count);
				complaints.add(complaint);
				count++;
			}
		}
		return complaints;
	}

	public List<CWNComplaint> getTotalComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return cwnComplaintRepository.findByLocationIn(location);
		return null;
	}

	@Override
	public List<CWNComplaint> findAllRemainingComplaints(List<String> location) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
