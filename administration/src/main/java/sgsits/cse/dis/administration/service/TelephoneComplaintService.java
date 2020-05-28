package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.model.TelephoneComplaint;


public interface TelephoneComplaintService {
	public List<TelephoneComplaint> getResolvedComplaints(String id);
	public List<TelephoneComplaint> getTotalComplaints(String id);
	public List<TelephoneComplaint> getRemainingComplaints(String id);
}
