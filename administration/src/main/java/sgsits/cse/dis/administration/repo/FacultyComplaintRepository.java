package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.FacultyComplaints;

//Faculty Complaint

@Repository("")
public interface FacultyComplaintRepository extends JpaRepository<FacultyComplaints, Long> {
	List<FacultyComplaints> findByCreatedBy(Long id);
	List<FacultyComplaints> findByStatus(String status);
	List<FacultyComplaints> findByStatusNot(String string);
}