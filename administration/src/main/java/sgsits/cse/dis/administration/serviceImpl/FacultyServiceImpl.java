package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.FacultyComplaint;
import sgsits.cse.dis.administration.repo.FacultyComplaintRepository;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.request.FacultyComplaintForm;
import sgsits.cse.dis.administration.service.FacultyComplaintService;

@Service
public class FacultyServiceImpl implements FacultyComplaintService {
	@Autowired
	FacultyComplaintRepository facultyComplaintRepository;

	@Override
	public List<FacultyComplaint> getRemainingFacultyComplaints() {
		return facultyComplaintRepository.findByStatusNot("Resolved");
	}

	@Override
	public FacultyComplaint addComplaint(FacultyComplaintForm facultyComplaintForm, String userId) {
		FacultyComplaint test = null;
		if (!facultyComplaintRepository.existsByCreatedByAndFacultyNameAndStatusNot(userId,
				facultyComplaintForm.getFacultyName(), "Resolved")) {
			FacultyComplaint facultyComplaints = new FacultyComplaint();
			facultyComplaints.setCreatedBy(userId);
			facultyComplaints.setCreatedDate((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
			facultyComplaints.setStatus("Not Assigned");
			facultyComplaints.setDetails(facultyComplaintForm.getDetails());
			facultyComplaints.setFacultyName(facultyComplaintForm.getFacultyName());
			test = facultyComplaintRepository.save(facultyComplaints);
		}
		return test;
	}

	@Override
	public FacultyComplaint editComplaint(EditComplaintForm editComplaintForm, String userId) {
		FacultyComplaint test = null;
		Optional<FacultyComplaint> fc = facultyComplaintRepository.findById(editComplaintForm.getId());
		if (fc.isPresent()) {
			fc.get().setModifiedBy(userId);
			fc.get().setModifiedDate((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
			fc.get().setStatus(editComplaintForm.getStatus());
			fc.get().setRemarks(editComplaintForm.getRemarks());
			if (editComplaintForm.getStatus().equals("Resolved"))
				fc.get().setDateOfResolution((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
			test = facultyComplaintRepository.save(fc.get());
		}
		return test;
	}
}
