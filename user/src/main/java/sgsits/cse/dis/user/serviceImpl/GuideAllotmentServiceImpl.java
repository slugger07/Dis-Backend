package sgsits.cse.dis.user.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.CreateBatch;
import sgsits.cse.dis.user.message.response.BatchData;
import sgsits.cse.dis.user.model.PgGuideAllotmentGuide;
import sgsits.cse.dis.user.model.PgGuideAllotmentStudent;
import sgsits.cse.dis.user.model.StaffProfile;
import sgsits.cse.dis.user.model.StudentProfile;
import sgsits.cse.dis.user.model.UgGuideAllotmentGuide;
import sgsits.cse.dis.user.model.UgGuideAllotmentStudent;
import sgsits.cse.dis.user.repo.PgGuideAllotmentGuideRepository;
import sgsits.cse.dis.user.repo.PgGuideAllotmentStudentRepository;
import sgsits.cse.dis.user.repo.StaffRepository;
import sgsits.cse.dis.user.repo.StudentRepository;
import sgsits.cse.dis.user.repo.UgGuideAllotmentGuideRepository;
import sgsits.cse.dis.user.repo.UgGuideAllotmentStudentRepository;
import sgsits.cse.dis.user.service.GuideAllotmentService;

@Component
public class GuideAllotmentServiceImpl implements GuideAllotmentService {

	@Autowired
	private UgGuideAllotmentGuideRepository ugGuideRepo;
	@Autowired
	private UgGuideAllotmentStudentRepository ugStudentRepo;
	@Autowired
	private PgGuideAllotmentGuideRepository pgGuideRepo;
	@Autowired
	private PgGuideAllotmentStudentRepository pgStudentRepo;
	@Autowired
	private StaffRepository staffRepo;
	@Autowired
	private StudentRepository studRepo;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@Override
	public List<BatchData> getAllBatches(String session, String ugOrPg) {
		List<BatchData> batches = new ArrayList<BatchData>();
		if(ugOrPg.equals("UG"))
		{
			List<UgGuideAllotmentGuide> guides = ugGuideRepo.findBySession(session);
			for(UgGuideAllotmentGuide guide : guides)
			{
				batches.add(formBatchFromUgGuide(guide));
			}
		}
		else if(ugOrPg.equals("PG"))
		{
			List<PgGuideAllotmentGuide> guides = pgGuideRepo.findBySession(session);
			for(PgGuideAllotmentGuide guide : guides)
			{
				batches.add(formBatchFromPgGuide(guide));			}			
		}
		return batches;
	}

	@Override
	public List<StudentProfile> getRemainingStudents(String session,String ugOrPg) {
		String courseId = "";
		int admissionYear;
		if (ugOrPg.equals("UG"))
			courseId = "C1";
		else if (ugOrPg.equals("PG"))
			courseId = "C2";
		String[] sessionYears = session.split("-");
		admissionYear = Integer.parseInt(sessionYears[0]);
		List<StudentProfile> allStudents = new ArrayList<StudentProfile>();
		allStudents = studRepo.findByCourseIdAndAdmissionYear(courseId, admissionYear);
		
		List<StudentProfile> allSelectedStudents = new ArrayList<StudentProfile>();

		List<BatchData> batches = getAllBatches(session, ugOrPg);
		for(BatchData batch : batches)
		{
			allSelectedStudents.addAll(batch.getStudents());
		}
		Set<StudentProfile> allSelectedStudentsSet = new HashSet<StudentProfile>(allSelectedStudents);
		allSelectedStudents = new ArrayList<StudentProfile>(allSelectedStudentsSet);
		
		if (allSelectedStudents.isEmpty())
		{
			return allStudents;
		}
		else
		{
			List<StudentProfile> allRemainingStudents = allStudents;
			allRemainingStudents.removeAll(allSelectedStudents);
			return allRemainingStudents;
		}
	}
	
	
	
	
	@Override
	public String createBatch(CreateBatch createBatch,String createdBy) throws ConflictException,DataIntegrityViolationException{
		
		if(createBatch.getUgOrPg().equals("UG"))
		{
			List<BatchData> batches = getAllBatches(createBatch.getSession(), createBatch.getUgOrPg());
			Integer batchIdNumber = batches.size() + 1;
			String batchId = "B" + batchIdNumber;
			try{
				//save ugGuideAllotmentGuide
				UgGuideAllotmentGuide test = ugGuideRepo.save(new UgGuideAllotmentGuide(batchId, createBatch.getGuide().getId(), 
					createBatch.getCoguide().getId(), createBatch.getSession(),createdBy,simpleDateFormat.format(new Date())));
				if(test.equals(null))
					throw new ConflictException("Unable to create batch.");
			
				//save ugGuideAllotmentStudent
				List<UgGuideAllotmentGuide> batch = ugGuideRepo.findByBatchIdAndSession(batchId, createBatch.getSession());
				String batchDetailsId = batch.get(0).getId();
			
				insertStudents(createBatch.getStudents(), createBatch.getUgOrPg(), batchDetailsId);
			}
			catch (DataIntegrityViolationException e) {
				throw new DataIntegrityViolationException("Batch Already Created.");
			}
			
			return "Batch created successfully";
		}
		else if(createBatch.getUgOrPg().equals("PG"))
		{
			List<BatchData> batches = getAllBatches(createBatch.getSession(), createBatch.getUgOrPg());
			Integer batchIdNumber = batches.size() + 1;
			String batchId = "B" + batchIdNumber;
			try{
				//save pgGuideAllotmentGuide
				PgGuideAllotmentGuide test = pgGuideRepo.save(new PgGuideAllotmentGuide(batchId, createBatch.getGuide().getId(), 
					createBatch.getCoguide().getId(), createBatch.getSession(),createdBy,simpleDateFormat.format(new Date())));
				if(test.equals(null))
					throw new ConflictException("Unable to create batch.");
			
				//save pgGuideAllotmentStudent
				List<PgGuideAllotmentGuide> batch = pgGuideRepo.findByBatchIdAndSession(batchId, createBatch.getSession());
				String batchDetailsId = batch.get(0).getId();
			
				insertStudents(createBatch.getStudents(), createBatch.getUgOrPg(), batchDetailsId);
			}
			catch (DataIntegrityViolationException e) {
				throw new DataIntegrityViolationException("Batch Already Created.");
			}
			return "Batch created successfully";
		}
		else
		{
			return "Cannot identify either UG or PG from the request";
		}
		
	}
	
	public void insertStudents(List<StudentProfile> students,String ugOrPg,String batchDetailsId) throws ConflictException
	{
		if(ugOrPg.equals("UG"))
		{
			for(StudentProfile stud : students)
			{
				String studentId = stud.getId();
				UgGuideAllotmentStudent testS = ugStudentRepo.save(new UgGuideAllotmentStudent(studentId, batchDetailsId));
				if(testS.equals(null))
					throw new ConflictException("Unable to add student information of batch");
			}	
		}
		else if(ugOrPg.equals("PG"))
		{
			for(StudentProfile stud : students)
			{
				String studentId = stud.getId();
				PgGuideAllotmentStudent testS = pgStudentRepo.save(new PgGuideAllotmentStudent(studentId, batchDetailsId));
				if(testS.equals(null))
					throw new ConflictException("Unable to add student information of batch");
			}
		}
	}
	
	//can be used to update only students of the batch, guide and co-guide
	@Transactional
	@Override
	public String updateBatch(BatchData updatedBatch,String modifiedBy) throws ConflictException,DataIntegrityViolationException
	{
		if(updatedBatch.getUgOrPg().equals("UG"))
		{
			try
			{
				String guideId=null;
				if(updatedBatch.getGuide()!=null)
					guideId = updatedBatch.getGuide().getId();
				String coGuideId=null;
				if(updatedBatch.getCoguide()!=null)
					coGuideId = updatedBatch.getCoguide().getId();
				
				ugGuideRepo.updateGuideBySessionAndBatchId(guideId, updatedBatch.getSession(),updatedBatch.getBatchId());
				ugGuideRepo.updateCoGuideBySessionAndBatchId(coGuideId, updatedBatch.getSession(),updatedBatch.getBatchId());
				ugGuideRepo.updateModifiedByAndModifiedDateBySessionAndBatchId(modifiedBy, simpleDateFormat.format(new Date()), updatedBatch.getSession(),updatedBatch.getBatchId());
				
				String batchDetailsId = ugGuideRepo.findByBatchIdAndSession(updatedBatch.getBatchId(), updatedBatch.getSession()).get(0).getId();
				
				List<UgGuideAllotmentStudent> oldStudents = ugStudentRepo.findByBatchDetailsId(batchDetailsId);
				
				deleteStudentsFromUg(oldStudents);
				
				insertStudents(updatedBatch.getStudents(), updatedBatch.getUgOrPg(), batchDetailsId);
				
				return "Batch Updated Successfully";				
			}
			catch(DataIntegrityViolationException e)
			{
				throw new DataIntegrityViolationException("Batch cannot be updated.");				
			}
		}
		else if(updatedBatch.getUgOrPg().equals("PG"))
		{
			try
			{
				String guideId=null;
				if(updatedBatch.getGuide()!=null)
					guideId = updatedBatch.getGuide().getId();
				String coGuideId=null;
				if(updatedBatch.getCoguide()!=null)
					coGuideId = updatedBatch.getCoguide().getId();
				
				pgGuideRepo.updateGuideBySessionAndBatchId(guideId, updatedBatch.getSession(),updatedBatch.getBatchId());
				pgGuideRepo.updateCoGuideBySessionAndBatchId(coGuideId, updatedBatch.getSession(),updatedBatch.getBatchId());
				pgGuideRepo.updateModifiedByAndModifiedDateBySessionAndBatchId(modifiedBy, simpleDateFormat.format(new Date()), updatedBatch.getSession(),updatedBatch.getBatchId());
				
				String batchDetailsId = pgGuideRepo.findByBatchIdAndSession(updatedBatch.getBatchId(), updatedBatch.getSession()).get(0).getId();
				
				List<PgGuideAllotmentStudent> oldStudents = pgStudentRepo.findByBatchDetailsId(batchDetailsId);
				
				deleteStudentsFromPg(oldStudents);
				
				insertStudents(updatedBatch.getStudents(), updatedBatch.getUgOrPg(), batchDetailsId);			
				
				return "Batch Updated Successfully";				
			}
			catch(DataIntegrityViolationException e)
			{
				throw new DataIntegrityViolationException("Batch cannot be updated.");				
			}			
		}
		return "Cannot identify either UG or PG from the request";
	}
	
	@Transactional
	void deleteStudentsFromUg(List<UgGuideAllotmentStudent> students)
	{
		for(UgGuideAllotmentStudent stud : students)
		{
			ugStudentRepo.delete(stud);
		}
	}
	
	@Transactional
	void deleteStudentsFromPg(List<PgGuideAllotmentStudent> students)
	{
		for(PgGuideAllotmentStudent stud : students)
		{
			pgStudentRepo.delete(stud);
		}
	}

	// doubt : what to throw in case no batch is found
	@Override
	public BatchData getStudentsBatch(String studentId,String ugOrPg) {
		String batchDetailsId;
		BatchData batch = null;
		
		if(ugOrPg.equals("UG"))
		{
			List<UgGuideAllotmentStudent> studs = ugStudentRepo.findByStudentId(studentId);
			if(studs.isEmpty())
			{
				throw new DataIntegrityViolationException("no batch found");
			}
			
			batchDetailsId = studs.get(0).getBatchDetailsId();
			
			Optional<UgGuideAllotmentGuide> batchDetails  = ugGuideRepo.findById(batchDetailsId);
			batch = formBatchFromUgGuide(batchDetails.get());
		}
		else if(ugOrPg.equals("PG"))
		{
			List<PgGuideAllotmentStudent> studs = pgStudentRepo.findByStudentId(studentId);
			if(studs.isEmpty())
			{
				throw new DataIntegrityViolationException("no batch found");
			}
			
			batchDetailsId = studs.get(0).getBatchDetailsId();
			
			Optional<PgGuideAllotmentGuide> batchDetails  = pgGuideRepo.findById(batchDetailsId);
			batch = formBatchFromPgGuide(batchDetails.get());
		}
		return batch;
	}

	@Override
	public List<BatchData> getGuidesBatch(String guideId,String ugOrPg) {
		List<BatchData> batch = new ArrayList<BatchData>();
		if(ugOrPg.equals("UG"))
		{
			List<UgGuideAllotmentGuide> guides = ugGuideRepo.findByGuideId(guideId);
			List<UgGuideAllotmentGuide> coGuides = ugGuideRepo.findByCoGuideId(guideId);
			for(UgGuideAllotmentGuide g : guides)
			{
				batch.add(formBatchFromUgGuide(g));
			}
			for(UgGuideAllotmentGuide g : coGuides)
			{
				if(g.getCoGuideId().equals(g.getGuideId())) // handling duplicate insertion
					continue;
				batch.add(formBatchFromUgGuide(g));
			}
		}
		else if(ugOrPg.equals("PG"))
		{
			List<PgGuideAllotmentGuide> guides = pgGuideRepo.findByGuideId(guideId);
			List<PgGuideAllotmentGuide> coGuides = pgGuideRepo.findByCoGuideId(guideId);
			for(PgGuideAllotmentGuide g : guides)
			{
				batch.add(formBatchFromPgGuide(g));
			}
			for(PgGuideAllotmentGuide g : coGuides)
			{
				if(g.getCoGuideId().equals(g.getGuideId())) // handling duplicate insertion
					continue;
				batch.add(formBatchFromPgGuide(g));
			}			
		}
		return batch;
	}
	
	BatchData formBatchFromUgGuide(UgGuideAllotmentGuide guide)
	{
		List<UgGuideAllotmentStudent> currStudents = ugStudentRepo.findByBatchDetailsId(guide.getId());
		String guideId = guide.getGuideId();
		String coGuideId = guide.getCoGuideId();
		Optional<StaffProfile> currGuide = Optional.empty(), currCoGuide = Optional.empty();
		if (guideId != null)
			currGuide = staffRepo.findById(guideId);
		if (coGuideId != null)
			currCoGuide = staffRepo.findById(coGuideId);
		List<String> ids = new ArrayList<String>();
		for(UgGuideAllotmentStudent stud : currStudents)
		{
			ids.add(stud.getStudentId());
		}
		return new BatchData(studRepo.findAllById(ids),currGuide.orElse(null),currCoGuide.orElse(null),guide.getSession(),"UG",guide.getBatchId());		
	}
	
	BatchData formBatchFromPgGuide(PgGuideAllotmentGuide guide)
	{
		List<PgGuideAllotmentStudent> currStudents = pgStudentRepo.findByBatchDetailsId(guide.getId());
		String guideId = guide.getGuideId();
		String coGuideId = guide.getCoGuideId();
		Optional<StaffProfile> currGuide = Optional.empty(), currCoGuide = Optional.empty();
		if (guideId != null)
			currGuide = staffRepo.findById(guideId);
		if (coGuideId != null)
			currCoGuide = staffRepo.findById(coGuideId);
		List<String> ids = new ArrayList<String>();
		for(PgGuideAllotmentStudent stud : currStudents)
		{
			ids.add(stud.getStudentId());
		}
		return new BatchData(studRepo.findAllById(ids),currGuide.orElse(null),currCoGuide.orElse(null),guide.getSession(),"PG",guide.getBatchId());				
	}
}
