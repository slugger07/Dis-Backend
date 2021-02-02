package sgsits.cse.dis.administration.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.ECCWComplaint;

//Engineering Cell and Central Workshop

@Repository("")
public interface ECCWComplaintRepository extends JpaRepository<ECCWComplaint, String> {
	List<ECCWComplaint> findByCreatedBy(String id);
	List<ECCWComplaint> findByLocationAndStatus(String location, String status);
	List<ECCWComplaint> findByLocation(String loc);
	List<ECCWComplaint> findByLocationAndStatusNot(String loc, String string);
	List<ECCWComplaint> findByLocationInAndStatus(List<String> location, String string);
	List<ECCWComplaint> findByLocationInAndStatusNot(List<String> location, String string);
	List<ECCWComplaint> findByLocationIn(List<String> location);
	long countByLocationAndStatusNot(String loc, String string);
	long countByLocationAndStatus(String loc, String string);
	long countByLocation(String loc);
	long countByLocationInAndStatusNot(List<String> loc, String string);
	long countByLocationInAndStatus(List<String> loc, String string);
	@Query(value = "select max(form_id) from engineering_cell_and_central_workshop_complaints", nativeQuery = true)
	long maxOfFormId();
	boolean existsByLocationAndDetailsAndStatusNot(String location, String details, String status);
	long countByLocationIn(List<String> loc);
	Optional<List<ECCWComplaint>> findByCreatedDate(String createdDate);
	Optional<List<ECCWComplaint>> findByCreatedDateAndLocation(String createdDate, String location);
}