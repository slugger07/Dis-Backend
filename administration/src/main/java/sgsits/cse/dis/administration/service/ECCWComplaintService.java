package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.model.ECCWComplaint;
import sgsits.cse.dis.administration.request.ComplaintDownloadReportForm;
import sgsits.cse.dis.administration.request.ECCWComplaintForm;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.response.ComplaintGeneralResponse;

public interface ECCWComplaintService {
	public List<ECCWComplaint> getResolvedComplaints(String id);
	public List<ECCWComplaint> getTotalComplaints(String id);
	List<ECCWComplaint> findAllRemainingComplaints(List<String> location);
	List<ECCWComplaint> addMultipleComplaint(List<ECCWComplaintForm> eccwComplaint, String userId);
	ECCWComplaint editComplaint(EditComplaintForm complaintForm, String userId);
	long countByLocationInAndStatusNot(List<String> locations, String status);
	long countByLocationInAndStatus(List<String> locations, String status);
	long countByLocationIn(List<String> loctions);
	List<ComplaintGeneralResponse> getDownloadReportData(ComplaintDownloadReportForm complaintInfo);
}
