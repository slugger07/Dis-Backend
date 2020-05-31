package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.feignClient.InfrastructureClient;
import sgsits.cse.dis.administration.model.EMRComplaint;
import sgsits.cse.dis.administration.repo.EMRComplaintRepository;
import sgsits.cse.dis.administration.request.ComplaintDownloadReportForm;
import sgsits.cse.dis.administration.request.EMRComplaintForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.response.ComplaintGeneralResponse;
import sgsits.cse.dis.administration.service.EMRComplaintService;

@Service
public class EMRComplaintServiceImpl implements EMRComplaintService {

	@Autowired
	EMRComplaintRepository emrsComplaintRepository;
	
	@Autowired
	private InfrastructureClient infrastructureClient;

	@Override
	public List<EMRComplaint> getResolvedComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return emrsComplaintRepository.findByLocationInAndStatus(location, "Resolved");
		return null;
	}

	@Override
	public List<EMRComplaint> getTotalComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return emrsComplaintRepository.findByLocationIn(location);
		return null;
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
				emrComplaint.setType("EMR");
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
			emrs.get().setModifiedDate((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
			emrs.get().setStatus(editComplaintForm.getStatus());
			emrs.get().setRemarks(editComplaintForm.getRemarks());
			if (editComplaintForm.getStatus().equals("Resolved"))
				emrs.get().setDateOfResolution((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
			test = emrsComplaintRepository.save(emrs.get());
		}
		return test;
	}

	@Override
	public long countByLocationInAndStatusNot(List<String> locations, String status) {
		return emrsComplaintRepository.countByLocationInAndStatusNot(locations, "Resolved");
	}

	@Override
	public long countByLocationInAndStatus(List<String> locations, String status) {
		return emrsComplaintRepository.countByLocationInAndStatus(locations, "Resolved");
	}

	@Override
	public long countByLocationIn(List<String> loctions) {
		return emrsComplaintRepository.countByLocationIn(loctions);
	}

	@Override
	public List<ComplaintGeneralResponse> getDownloadReportData(ComplaintDownloadReportForm complaintInfo) {
		Optional<List<EMRComplaint>> emrs = null;
		
		if(complaintInfo.getLocation().equals("")) {
			emrs = emrsComplaintRepository.findByCreatedDate(complaintInfo.getCreatedDate());
		}
		else {
			emrs = emrsComplaintRepository.findByCreatedDateAndLocation(complaintInfo.getCreatedDate(), complaintInfo.getLocation());
		}
		List<ComplaintGeneralResponse> complaints = new ArrayList<>();
		if(emrs.isPresent()) {
			int count = 1;
			for(EMRComplaint cwn : emrs.get()) {
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
	
	@Override
	public List<EMRComplaint> getRemainingComplaints(String id) {
		List<String> location = infrastructureClient.findInchargeOf(id);
		if (location.size() != 0)
			return emrsComplaintRepository.findByLocationInAndStatusNot(location, "Resolved");
		return null;
	}

	@Override
	public List<EMRComplaint> findAllRemainingComplaints(List<String> location) {
		return emrsComplaintRepository.findByLocationInAndStatusNot(location, "Resolved");
	}
}
