package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.StudentComplaint;

//Student Complaint

@Repository("")
public interface StudentComplaintRepository extends JpaRepository<StudentComplaint, String> {
	List<StudentComplaint> findByCreatedBy(String id);
	List<StudentComplaint>findByStatusNot(String string);
	List<StudentComplaint> findByStatus(String string);
}