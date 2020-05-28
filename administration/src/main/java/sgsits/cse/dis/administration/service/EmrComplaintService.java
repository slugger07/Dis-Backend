package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.model.EMRComplaint;

public interface EmrComplaintService {
	public List<EMRComplaint> getResolvedComplaints(String id);
}
