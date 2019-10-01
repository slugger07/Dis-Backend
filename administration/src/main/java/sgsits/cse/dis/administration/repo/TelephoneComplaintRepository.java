package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.TelephoneComplaints;

//Cleanliness Complaint

@Repository("")
public interface TelephoneComplaintRepository extends JpaRepository<TelephoneComplaints, Long> {
	List<TelephoneComplaints> findByLocationAndStatus(String location, String status);
	List<TelephoneComplaints> findByCreatedBy(Long id);
	List<TelephoneComplaints> findByLocation(String loc);
	List<TelephoneComplaints> findByLocationAndStatusNot(String loc, String string);
	List<TelephoneComplaints> findByLocationInAndStatus(List<String> location, String string);
	List<TelephoneComplaints> findByLocationInAndStatusNot(List<String> location, String string);
	List<TelephoneComplaints> findByLocationIn(List<String> location);
}