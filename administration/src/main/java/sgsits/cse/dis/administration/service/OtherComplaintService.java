package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.model.OtherComplaint;

public interface OtherComplaintService {
	public List<OtherComplaint> getMyComplaints(String id);
	public List<OtherComplaint> getResolvedComplaints(String userType, String id);
}
