package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.CWNComplaint;
//CWN Maintenance

@Repository("")
public interface CWNComplaintRepository extends JpaRepository<CWNComplaint, String> {
	List<CWNComplaint> findByCreatedBy(String id);
	List<CWNComplaint> findByLocationAndStatus(String location, String status);
	List<CWNComplaint> findByLocation(String loc);
	List<CWNComplaint> findByLocationAndStatusNot(String loc, String status);
	List<CWNComplaint> findByLocationInAndStatus(List<String> location, String status);
	List<CWNComplaint> findByLocationInAndStatusNot(List<String> location, String status);
	List<CWNComplaint> findByLocationIn(List<String> location);
	long countByLocationAndStatusNot(String loc, String status);
	long countByLocationAndStatus(String loc, String status);
	long countByLocation(String loc);
	boolean existsByLocationAndDetailsAndStatusNot(String location, String details, String status);
	
	@Query(value = "select max(form_id) from cwn_maintenance_complaints", nativeQuery = true)
	long maxOfFormId();
}