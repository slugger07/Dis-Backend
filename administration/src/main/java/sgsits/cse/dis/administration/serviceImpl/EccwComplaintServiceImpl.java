package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.ECCWComplaint;
import sgsits.cse.dis.administration.repo.ECCWComplaintRepository;
import sgsits.cse.dis.administration.service.ComplaintService;

@Service
public class EccwComplaintServiceImpl implements ComplaintService<ECCWComplaint>{
	@Autowired
	ECCWComplaintRepository eccwComplaintRepository;
	
	@Override
	public List<ECCWComplaint> findAllRemainingComplaints(List<String> location) {
		return eccwComplaintRepository.findByLocationInAndStatusNot(location, "Resolved");
	}

	@Override
	public ECCWComplaint addComplaint(ECCWComplaint complaintForm, String userId) {
		ECCWComplaint eccwComplaint = new ECCWComplaint();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		eccwComplaint.setStatus("Not Resolved");
		eccwComplaint.setCreatedBy(userId);
		eccwComplaint.setCreatedDate(simpleDateFormat.format(new Date()));
		eccwComplaint.setLocation(complaintForm.getLocation());
		eccwComplaint.setFormId(complaintForm.getFormId());
		eccwComplaint.setPdfId(complaintForm.getPdfId());
		ECCWComplaint test = eccwComplaintRepository.save(eccwComplaint);
		return test;
	}

}
