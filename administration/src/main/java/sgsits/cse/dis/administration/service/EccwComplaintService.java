package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.model.ECCWComplaint;

public interface EccwComplaintService {
	public List<ECCWComplaint> getResolvedComplaints(String id);
}
