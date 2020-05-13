package sgsits.cse.dis.user.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.CreateBatch;
import sgsits.cse.dis.user.message.response.BatchData;

public interface GuideAllotmentService {
	
	List<BatchData> getAllBatches(String session,String ugOrPg);
	String createBatch(CreateBatch createBatch) throws ConflictException,DataIntegrityViolationException;
	String updateBatch(BatchData updatedBatch) throws ConflictException,DataIntegrityViolationException;
}
