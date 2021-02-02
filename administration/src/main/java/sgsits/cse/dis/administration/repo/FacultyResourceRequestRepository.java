package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.FacultyResourceRequest;

@Repository
public interface FacultyResourceRequestRepository extends JpaRepository<FacultyResourceRequest, Long>{

	List<FacultyResourceRequest> getFacultyResourceRequestByStatus(String status);
	
	List<FacultyResourceRequest> findByPriorityContainingIgnoreCase(String priority);
}
