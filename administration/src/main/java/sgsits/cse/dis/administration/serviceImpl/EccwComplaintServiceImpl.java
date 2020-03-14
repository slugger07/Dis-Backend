package sgsits.cse.dis.administration.serviceImpl;

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
	public ECCWComplaint addComplaint(ECCWComplaint complaintForm) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
