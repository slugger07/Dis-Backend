package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.user.model.UgGuideAllotmentStudent;

public interface UgGuideAllotmentStudentRepository extends JpaRepository<UgGuideAllotmentStudent, String> {
	List<UgGuideAllotmentStudent> findByBatchDetailsId(String batchDetailsId);
	List<UgGuideAllotmentStudent> findByStudentId(String studentId);
}
