package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.OtherComplaint;

//Other Complaints

@Repository("")
public interface OtherComplaintRepository extends JpaRepository<OtherComplaint, String>{
	List<OtherComplaint> findByCreatedBy(String id);
	List<OtherComplaint> findByAssignedToAndStatus(String id, String status);
	List<OtherComplaint> findByStatus(String status);
	List<OtherComplaint> findByAssignedTo(String id);
	List<OtherComplaint> findByStatusNot(String status);
	List<OtherComplaint> findByAssignedToAndStatusNot(String id, String status);
	long countByStatusNot(String string);
	long countByAssignedToAndStatusNot(String id, String status);
	long countByCreatedBy(String id);
	long countByStatus(String string);
	long countByAssignedToAndStatus(String id, String string);
	long countByAssignedTo(String id);
	long count();
	boolean existsByCreatedByAndDetailsAndStatusNot(String id, String details, String string);
}