package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.LEComplaint;

//Lab Equipment Complaint

@Repository("")
public interface LEComplaintRepository extends JpaRepository<LEComplaint, String> {
	List<LEComplaint> findByLabInAndStatusNot(List<String> location, String string);
	List<LEComplaint> findByCreatedBy(String id);
	List<LEComplaint> findByLabAndStatus(String lab, String status);
	List<LEComplaint> findByLab(String loc);
	List<LEComplaint> findByLabAndStatusNot(String lab, String string);
	List<LEComplaint> findByLabInAndStatus(List<String> location, String string);
	List<LEComplaint> findByLabIn(List<String> location);
	long countByLabAndStatusNot(String loc, String string);
	long countByCreatedBy(String id);
	long countByLabInAndStatusNot(List<String> loc, String string);
	long countByLabInAndStatus(List<String> loc, String string);
	long countByLab(String loc);
	boolean existsByCreatedByAndLabAndSystemNoAndStatusNot(String id, String lab, String systemNo, String status);
	long countByLabIn(List<String> loc);
}