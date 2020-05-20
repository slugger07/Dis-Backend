package sgsits.cse.dis.administration.service;

import java.util.List;

import sgsits.cse.dis.administration.model.CleanlinessComplaint;

public interface CleanlinessComplaintService {
	List<CleanlinessComplaint> getMyComplaints(String id);
}