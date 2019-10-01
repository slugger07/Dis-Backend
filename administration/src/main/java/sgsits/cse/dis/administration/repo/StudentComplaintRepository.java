package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.StudentComplaints;

//Student Complaint

@Repository("")
public interface StudentComplaintRepository extends JpaRepository<StudentComplaints, Long> {
	List<StudentComplaints> findByCreatedBy(long id);
	List<StudentComplaints> findByStatus(String status);
	List<StudentComplaints>findByStatusNot(String string);
}