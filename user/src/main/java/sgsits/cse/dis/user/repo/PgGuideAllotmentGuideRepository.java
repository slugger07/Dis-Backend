package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.user.model.PgGuideAllotmentGuide;

public interface PgGuideAllotmentGuideRepository extends JpaRepository<PgGuideAllotmentGuide, String> {
	List<PgGuideAllotmentGuide> findBySession(String session);
	List<PgGuideAllotmentGuide> findByBatchIdAndSession(String batchId, String session);
}
