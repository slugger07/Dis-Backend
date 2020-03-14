package sgsits.cse.dis.administration.service;

import sgsits.cse.dis.administration.model.CleanlinessComplaint;

public interface CleanlinessComplaintService extends ComplaintService<CleanlinessComplaint> {
	boolean checkIfComplaintExist(String userId, String location, String status);
}
