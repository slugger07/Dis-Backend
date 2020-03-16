package sgsits.cse.dis.administration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.OtherComplaint;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.request.OtherComplaintForm;

@Service
public interface OtherComplaintService{
	boolean checkIfComplaintExist(String id, String details, String status);
	List<OtherComplaint> findAllRemainingComplaints(List<String> location);
	OtherComplaint addComplaint(OtherComplaintForm complaintForm, String userId);
	OtherComplaint editComplaint(EditComplaintForm complaintForm, String userId);
}
