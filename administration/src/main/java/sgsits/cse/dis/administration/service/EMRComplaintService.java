package sgsits.cse.dis.administration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.EMRComplaint;
import sgsits.cse.dis.administration.request.EMRComplaintForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;

@Service
public interface EMRComplaintService {
	List<EMRComplaint> findAllRemainingComplaints(List<String> location);
	List<EMRComplaint> addMultipleComplaint(List<EMRComplaintForm> emrComplaints, String userId);
	EMRComplaint editComplaint(EditComplaintForm complaintForm, String userId);
	long countByLocationInAndStatusNot(List<String> locations, String status);
	long countByLocationInAndStatus(List<String> locations, String status);
	long countByLocationIn(List<String> loctions);
}
