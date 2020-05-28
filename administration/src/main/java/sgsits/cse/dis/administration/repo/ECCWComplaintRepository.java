package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.ECCWComplaint;

//Engineering Cell and Central Workshop

@Repository("")
public interface ECCWComplaintRepository extends JpaRepository<ECCWComplaint, String> {
//	List<ECCWComplaint> findByCreatedBy(Long id);
//	List<ECCWComplaint> findByLocationAndStatus(String location, String status);
//	List<ECCWComplaint> findByLocation(String loc);
//	List<ECCWComplaint> findByLocationAndStatusNot(String loc, String string);
	List<ECCWComplaint> findByLocationInAndStatus(List<String> location, String string);
//	List<ECCWComplaint> findByLocationInAndStatusNot(List<String> location, String string);
	List<ECCWComplaint> findByLocationIn(List<String> location);
}