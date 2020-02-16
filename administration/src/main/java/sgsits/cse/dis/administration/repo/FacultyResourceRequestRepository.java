package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.FacultyResourceRequest;

@Repository
public interface FacultyResourceRequestRepository extends JpaRepository<FacultyResourceRequest, Long>{

//	boolean existsByCreatedByAndResourceCategoryAndDetailsAndStatusNot(long id, String resourceCategory, String details, String status);
//
//	boolean existsByCreatedBy(long id);
//
//	List<FacultyResourceRequest> findByStatus(String string);
//
//	List<FacultyResourceRequest> findByStatusNot(String string);
//
//	List<FacultyResourceRequest> findByCreatedByAndStatus(long id, String string);
//
//	List<FacultyResourceRequest> findByCreatedByAndStatusNot(long id, String string);

//	FacultyResourceRequest save(FacultyResourceRequest facultyResourceRequest);
}
