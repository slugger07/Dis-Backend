package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.ECCWComplaints;

//Engineering Cell and Central Workshop

@Repository("")
public interface ECCWComplaintRepository extends JpaRepository<ECCWComplaints, Long> {
	List<ECCWComplaints> findByCreatedBy(Long id);
	List<ECCWComplaints> findByLocationAndStatus(String location, String status);
	List<ECCWComplaints> findByLocation(String loc);
	List<ECCWComplaints> findByLocationAndStatusNot(String loc, String string);
	List<ECCWComplaints> findByLocationInAndStatus(List<String> location, String string);
	List<ECCWComplaints> findByLocationInAndStatusNot(List<String> location, String string);
	List<ECCWComplaints> findByLocationIn(List<String> location);
}