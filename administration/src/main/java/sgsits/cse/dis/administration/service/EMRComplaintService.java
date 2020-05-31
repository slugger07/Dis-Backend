package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.model.EMRComplaint;
import sgsits.cse.dis.administration.request.ComplaintDownloadReportForm;
import sgsits.cse.dis.administration.request.EMRComplaintForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.response.ComplaintGeneralResponse;

public interface EMRComplaintService {
	public List<EMRComplaint> getResolvedComplaints(String id);
	public List<EMRComplaint> getTotalComplaints(String id);
	public List<EMRComplaint> getRemainingComplaints(String id);
	List<EMRComplaint> findAllRemainingComplaints(List<String> location);
	List<EMRComplaint> addMultipleComplaint(List<EMRComplaintForm> emrComplaints, String userId);
	EMRComplaint editComplaint(EditComplaintForm complaintForm, String userId);
	long countByLocationInAndStatusNot(List<String> locations, String status);
	long countByLocationInAndStatus(List<String> locations, String status);
	long countByLocationIn(List<String> loctions);
	List<ComplaintGeneralResponse> getDownloadReportData(ComplaintDownloadReportForm complaintInfo);
}
