package sgsits.cse.dis.administration.service;


import java.util.List;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.administration.model.CleanlinessComplaint;

@Component
public interface CleanlinessComplaintService {
	
	List<CleanlinessComplaint> getAllCleanlinessComplaints(List<String> locations);
	
}
