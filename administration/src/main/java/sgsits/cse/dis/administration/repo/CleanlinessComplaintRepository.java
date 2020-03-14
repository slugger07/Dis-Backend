package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.CleanlinessComplaint;

//Cleanliness Complaint

@Repository("")
public interface CleanlinessComplaintRepository extends JpaRepository<CleanlinessComplaint, Long> {
//	List<CleanlinessComplaint> findByCreatedBy(Long id);
//	List<CleanlinessComplaint> findByLocationAndStatus(String location, String status);
//	List<CleanlinessComplaint> findByLocation(String loc);
//	List<CleanlinessComplaint> findByLocationAndStatusNot(String loc, String string);
	boolean existsByCreatedByAndLocationAndStatusNot(String userId, String location, String status);
//	List<CleanlinessComplaint> findByLocationInAndStatus(List<String> location, String string);
	List<CleanlinessComplaint> findByLocationInAndStatusNot(List<String> location, String string);
//	List<CleanlinessComplaint> findByLocationIn(List<String> location);
}