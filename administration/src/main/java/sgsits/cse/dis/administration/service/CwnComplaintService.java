package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.model.CWNComplaint;

public interface CwnComplaintService {
	public List<CWNComplaint> getResolvedComplaints(String id);
}
