package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.CleanlinessComplaint;

//Cleanliness Complaint

@Repository("")
public interface CleanlinessComplaintRepository extends JpaRepository<CleanlinessComplaint, String> {
	List<CleanlinessComplaint> findByCreatedBy(String id);
	List<CleanlinessComplaint> findByLocationAndStatus(String location, String status);
	List<CleanlinessComplaint> findByLocation(String loc);
	List<CleanlinessComplaint> findByLocationAndStatusNot(String loc, String string);
	boolean existsByCreatedByAndLocationAndStatusNot(String id, String location, String status);
	List<CleanlinessComplaint> findByLocationInAndStatus(List<String> location, String string);
	List<CleanlinessComplaint> findByLocationInAndStatusNot(List<String> location, String string);
	List<CleanlinessComplaint> findByLocationIn(List<String> location);
	long countByLocationAndStatusNot(String loc, String string);
	long countByLocationInAndStatusNot(List<String> loc, String string);
	long countByLocationInAndStatus(List<String> loc, String string);
	long countByCreatedBy(String id);
	long countByLocationAndStatus(String loc, String string);
	long countByLocationIn(List<String> loc);

}