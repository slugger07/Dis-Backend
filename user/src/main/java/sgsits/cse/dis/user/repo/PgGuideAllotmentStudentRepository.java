package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.user.model.PgGuideAllotmentStudent;

public interface PgGuideAllotmentStudentRepository extends JpaRepository<PgGuideAllotmentStudent, String> {
	List<PgGuideAllotmentStudent> findByBatchDetailsId(String batchDetailsId);	
}
