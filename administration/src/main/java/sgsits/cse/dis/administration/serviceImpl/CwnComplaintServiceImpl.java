package sgsits.cse.dis.administration.serviceImpl;

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
	public CWNComplaint addComplaint(CWNComplaint complaintForm) {
		// TODO Auto-generated method stub
		return null;
	}

}
