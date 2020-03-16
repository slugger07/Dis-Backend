package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.EMRComplaint;

//Electrical Maintenance and repairs section

@Repository("")
public interface EMRComplaintRepository extends JpaRepository<EMRComplaint, String> {
	List<EMRComplaint> findByLocationAndStatus(String location, String status);
	List<EMRComplaint> findByCreatedBy(String id);
	List<EMRComplaint> findByLocation(String loc);
	List<EMRComplaint> findByLocationAndStatusNot(String loc, String string);
	List<EMRComplaint> findByLocationInAndStatus(List<String> location, String string);
	List<EMRComplaint> findByLocationInAndStatusNot(List<String> location, String string);
	List<EMRComplaint> findByLocationIn(List<String> location);
	long countByLocationAndStatusNot(String loc, String string);
	long countByLocationAndStatus(String loc, String string);
	long countByLocation(String loc);
	boolean existsByLocationAndDetailsAndStatusNot(String location, String details, String status);
	
	@Query(value = "select max(form_id) from electrical_maintenance_and_repairs_section_complaints", nativeQuery = true)
	long maxOfFormId();
}