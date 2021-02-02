package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.FacultyComplaint;

//Faculty Complaint

@Repository("")
public interface FacultyComplaintRepository extends JpaRepository<FacultyComplaint, String> {
	List<FacultyComplaint> findByCreatedBy(String id);
	List<FacultyComplaint> findByStatus(String status);
	List<FacultyComplaint> findByStatusNot(String string);
	long countByStatusNot(String string);
	long countByCreatedBy(String userId);
	long countByStatus(String string);
	boolean existsByCreatedByAndFacultyNameAndStatusNot(String id, String facultyName, String status);
	long count();
}