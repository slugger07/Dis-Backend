package sgsits.cse.dis.user.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.CreateBatch;
import sgsits.cse.dis.user.message.response.BatchData;
import sgsits.cse.dis.user.model.StudentProfile;

public interface GuideAllotmentService {
	
	List<BatchData> getAllBatches(String session,String ugOrPg);
	String createBatch(CreateBatch createBatch,String createdBy) throws ConflictException,DataIntegrityViolationException;
	String updateBatch(BatchData updatedBatch,String updatedBy) throws ConflictException,DataIntegrityViolationException;
	List<StudentProfile> getRemainingStudents(String session,String ugOrPg);
	BatchData getStudentsBatch(String studentId,String ugOrPg);
	List<BatchData> getGuidesBatch(String guideId,String ugOrPg);
}
