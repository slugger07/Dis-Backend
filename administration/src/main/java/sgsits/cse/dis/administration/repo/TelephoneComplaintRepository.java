package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.TelephoneComplaint;

//Cleanliness Complaint

@Repository("")
public interface TelephoneComplaintRepository extends JpaRepository<TelephoneComplaint, String> {
	List<TelephoneComplaint> findByLocationAndStatus(String location, String status);
	List<TelephoneComplaint> findByCreatedBy(String id);
	List<TelephoneComplaint> findByLocation(String loc);
	List<TelephoneComplaint> findByLocationAndStatusNot(String loc, String status);
	List<TelephoneComplaint> findByLocationInAndStatus(List<String> location, String status);
	List<TelephoneComplaint> findByLocationInAndStatusNot(List<String> location, String status);
	List<TelephoneComplaint> findByLocationIn(List<String> location);
	long countByLocationAndStatusNot(String loc, String status);
	long countByLocationAndStatus(String loc, String status);
	long countByLocation(String loc);
	boolean existsByExtensionNoAndLocationAndDetailsAndStatusNot(String extensionNo, String location, String details,
			String status);
	@Query(value = "select max(form_id) from telephone_complaints", nativeQuery = true)
	long maxOfFormId();
}