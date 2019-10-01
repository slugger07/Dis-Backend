package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.CleanlinessComplaints;

//Cleanliness Complaint

@Repository("")
public interface CleanlinessComplaintRepository extends JpaRepository<CleanlinessComplaints, Long> {
	List<CleanlinessComplaints> findByCreatedBy(Long id);
	List<CleanlinessComplaints> findByLocationAndStatus(String location, String status);
	List<CleanlinessComplaints> findByLocation(String loc);
	List<CleanlinessComplaints> findByLocationAndStatusNot(String loc, String string);
	boolean existsByCreatedByAndLocationAndStatusNot(long id, String location, String status);
	List<CleanlinessComplaints> findByLocationInAndStatus(List<String> location, String string);
	List<CleanlinessComplaints> findByLocationInAndStatusNot(List<String> location, String string);
	List<CleanlinessComplaints> findByLocationIn(List<String> location);
}