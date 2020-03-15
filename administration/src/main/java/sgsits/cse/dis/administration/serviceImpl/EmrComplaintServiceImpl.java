package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.EMRComplaint;
import sgsits.cse.dis.administration.repo.EMRComplaintRepository;
import sgsits.cse.dis.administration.service.ComplaintService;

@Service
public class EmrComplaintServiceImpl implements ComplaintService<EMRComplaint>{

	@Autowired
	EMRComplaintRepository emrsComplaintRepository;
	
	@Override
	public List<EMRComplaint> findAllRemainingComplaints(List<String> location) {
		return emrsComplaintRepository.findByLocationInAndStatusNot(location, "Resolved");
	}

	@Override
	public EMRComplaint addComplaint(EMRComplaint complaintForm, String userId) {
		EMRComplaint emrComplaint = new EMRComplaint();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		emrComplaint.setStatus("Not Resolved");
		emrComplaint.setCreatedBy(userId);
		emrComplaint.setCreatedDate(simpleDateFormat.format(new Date()));
		emrComplaint.setLocation(complaintForm.getLocation());
		emrComplaint.setFormId(complaintForm.getFormId());
		emrComplaint.setPdfId(complaintForm.getPdfId());
		EMRComplaint test = emrsComplaintRepository.save(emrComplaint);
		return test;
	}

}
