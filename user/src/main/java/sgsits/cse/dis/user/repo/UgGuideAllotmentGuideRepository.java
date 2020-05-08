package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.user.model.UgGuideAllotmentGuide;

public interface UgGuideAllotmentGuideRepository extends JpaRepository<UgGuideAllotmentGuide, String> {
	List<UgGuideAllotmentGuide> findBySession(String session);
	List<UgGuideAllotmentGuide> findByBatchIdAndSession(String batchId, String session);
}
