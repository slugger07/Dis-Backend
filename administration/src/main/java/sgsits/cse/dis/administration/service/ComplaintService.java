package sgsits.cse.dis.administration.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ComplaintService<C,S> {
	List<C> findAllRemainingComplaints(List<String> location);
	C addComplaint(S complaintForm, String userId);
}
