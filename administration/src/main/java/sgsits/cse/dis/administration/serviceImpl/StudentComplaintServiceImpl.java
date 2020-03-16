package sgsits.cse.dis.administration.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.administration.model.StudentComplaint;
import sgsits.cse.dis.administration.repo.StudentComplaintRepository;
import sgsits.cse.dis.administration.request.EditComplaintForm;
import sgsits.cse.dis.administration.request.StudentComplaintForm;
import sgsits.cse.dis.administration.service.StudentComplaintService;

@Service
public class StudentComplaintServiceImpl implements StudentComplaintService{
	@Autowired
	StudentComplaintRepository studentComplaintRepository;
	
	@Override
	public List<StudentComplaint> getRemainingStudentComplaints() {
		return studentComplaintRepository.findByStatusNot("Resolved");
	}

	@Override
	public boolean existsByCreatedByAndRollNoAndNameAndYearAndStatusNot(String userId, String rollNo,
			String studentName, String year, String status) {
		if(!studentComplaintRepository.existsByCreatedByAndRollNoAndNameAndYearAndStatusNot(userId, rollNo, studentName, year, status)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean existsByCreatedByAndRollNoAndYearAndStatusNot(String userId, String rollNo, String year,
			String status) {
		if(!studentComplaintRepository.existsByCreatedByAndRollNoAndYearAndStatusNot(userId, rollNo, year, status)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean existsByCreatedByAndNameAndYearAndStatusNot(String userId, String studentName, String year,
			String status) {
		if(!studentComplaintRepository.existsByCreatedByAndNameAndYearAndStatusNot(userId, studentName, year, status)) {
			return true;
		}
		return false;
	}

	@Override
	public StudentComplaint addComplaint(StudentComplaintForm complaintForm, String userId) {
		StudentComplaint studentComplaint = new StudentComplaint(complaintForm.getStudentRollNo(),
																 complaintForm.getStudentName(),
																 complaintForm.getYear(),
																 complaintForm.getCourse());
		studentComplaint.setCreatedBy(userId);
		studentComplaint.setCreatedDate((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
		studentComplaint.setStatus("Not Assigned");
		StudentComplaint test = studentComplaintRepository.save(studentComplaint);
		return test;
	}

	@Override
	public StudentComplaint editComplaint(EditComplaintForm editComplaintForm, String userId) {
		Optional<StudentComplaint> sc = studentComplaintRepository.findById(editComplaintForm.getId());
		StudentComplaint test = null;
		if (sc.isPresent()) {
			sc.get().setModifiedBy(userId);
			sc.get().setModifiedDate((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
			sc.get().setStatus(editComplaintForm.getStatus());
			sc.get().setRemarks(editComplaintForm.getRemarks());
			if(editComplaintForm.getStatus().equals("Resolved"))
				sc.get().setDateOfResolution((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
			test = studentComplaintRepository.save(sc.get());
		}
		return test;
	}
}