package sgsits.cse.dis.administration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.CWNComplaint;
import sgsits.cse.dis.administration.request.CWNComplaintForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;

@Service
public interface CWNComplaintService {
	List<CWNComplaint> findAllRemainingComplaints(List<String> location);
	List<CWNComplaint> addMutipleComplaints(List<CWNComplaintForm> complaintForm, String userId);
	CWNComplaint editComplaint(EditComplaintForm complaintForm, String userId);
	long countByLocationInAndStatusNot(List<String> locations, String status);
	long countByLocationInAndStatus(List<String> locations, String status);
	long countByLocationIn(List<String> loctions);
}
