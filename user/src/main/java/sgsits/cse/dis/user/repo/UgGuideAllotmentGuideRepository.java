package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import sgsits.cse.dis.user.model.UgGuideAllotmentGuide;

public interface UgGuideAllotmentGuideRepository extends JpaRepository<UgGuideAllotmentGuide, String> {
	List<UgGuideAllotmentGuide> findBySession(String session);
	List<UgGuideAllotmentGuide> findByBatchIdAndSession(String batchId, String session);
	
	@Query(value = "UPDATE ug_guide_allotment_guide_details SET guide_id = ?1 where session = ?2 and batch_id = ?3 ",nativeQuery = true)
	@Modifying
	void updateGuideBySessionAndBatchId(String guideId,String session,String batchId);
	
	@Query(value = "UPDATE ug_guide_allotment_guide_details SET co_guide_id = ?1 where session = ?2 and batch_id = ?3 ",nativeQuery = true)
	@Modifying
	void updateCoGuideBySessionAndBatchId(String coGuideId,String session,String batchId);
}
