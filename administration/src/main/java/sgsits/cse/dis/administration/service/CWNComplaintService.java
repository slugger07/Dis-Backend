package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.model.CWNComplaint;
import sgsits.cse.dis.administration.request.CWNComplaintForm;
import sgsits.cse.dis.administration.request.ComplaintDownloadReportForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.response.ComplaintGeneralResponse;

public interface CWNComplaintService {
	public List<CWNComplaint> getResolvedComplaints(String id);
	public List<CWNComplaint> getTotalComplaints(String id);
	List<CWNComplaint> findAllRemainingComplaints(List<String> location);
	List<CWNComplaint> addMutipleComplaints(List<CWNComplaintForm> complaintForm, String userId);
	CWNComplaint editComplaint(EditComplaintForm complaintForm, String userId);
	long countByLocationInAndStatusNot(List<String> locations, String status);
	long countByLocationInAndStatus(List<String> locations, String status);
	long countByLocationIn(List<String> loctions);
	List<ComplaintGeneralResponse> getDownloadReportData(ComplaintDownloadReportForm complaintInfo);
}
