package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.administration.model.CleanlinessComplaint;
import sgsits.cse.dis.administration.repo.CleanlinessComplaintRepository;
import sgsits.cse.dis.administration.service.CleanlinessComplaintService;

@Component
public class CleanlinessComplaintServiceImpl implements CleanlinessComplaintService {

	@Autowired
	CleanlinessComplaintRepository cleanlinessComplaintRepository;

	@Override
	public List<CleanlinessComplaint> findAllRemainingComplaints(List<String> location) {
		System.out.println(location);
		return cleanlinessComplaintRepository.findByLocationInAndStatusNot(location, "Resolved");
	}

	@Override
	public CleanlinessComplaint addComplaint(CleanlinessComplaint complaintForm, String userId) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		CleanlinessComplaint test = null;
		CleanlinessComplaint cleanlinessComplaint = new CleanlinessComplaint();
		cleanlinessComplaint.setDetails(complaintForm.getDetails());
		cleanlinessComplaint.setLocation(complaintForm.getLocation());
		cleanlinessComplaint.setLevelOfDust(complaintForm.getLevelOfDust());
		cleanlinessComplaint.setCreatedBy(userId);
		cleanlinessComplaint.setCreatedDate(simpleDateFormat.format(new Date()));
		cleanlinessComplaint.setStatus("Not Resolved");
		test = cleanlinessComplaintRepository.save(cleanlinessComplaint);
		return test;
	}

	@Override
	public boolean checkIfComplaintExist(String userId, String location, String status) {
		if (cleanlinessComplaintRepository.existsByCreatedByAndLocationAndStatusNot(userId, location, status)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<CleanlinessComplaint> getMyComplaints(String userId) {
		return cleanlinessComplaintRepository.findByCreatedBy(userId);
	}
}
