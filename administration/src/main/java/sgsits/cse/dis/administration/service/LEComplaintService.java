package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.model.LEComplaint;

public interface LEComplaintService {
	public List<LEComplaint> getMyComplaints(String id);
	public List<LEComplaint> getResolvedComplaints(String id);
}
