package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.CWNComplaint;
import sgsits.cse.dis.administration.repo.CWNComplaintRepository;
import sgsits.cse.dis.administration.service.ComplaintService;

@Service
public class CwnComplaintServiceImpl implements ComplaintService<CWNComplaint>{

	@Autowired
	CWNComplaintRepository cwnComplaintRepository;
	
	@Override
	public List<CWNComplaint> findAllRemainingComplaints(List<String> location) {
		return cwnComplaintRepository.findByLocationInAndStatusNot(location, "Resolved");
	}

	@Override
	public CWNComplaint addComplaint(CWNComplaint complaintForm, String userId) {
		CWNComplaint cwnComplaint = new CWNComplaint();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		cwnComplaint.setStatus("Not Resolved");
		cwnComplaint.setCreatedBy(userId);
		cwnComplaint.setCreatedDate(simpleDateFormat.format(new Date()));
		cwnComplaint.setLocation(complaintForm.getLocation());
		cwnComplaint.setFormId(complaintForm.getFormId());
		cwnComplaint.setPdfId(complaintForm.getPdfId());
		CWNComplaint test = cwnComplaintRepository.save(cwnComplaint);
		return test;
	}

	@Override
	public List<CWNComplaint> getMyComplaints(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
