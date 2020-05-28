package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.TelephoneComplaint;


@Repository("")
public interface TelephoneComplaintRepository extends JpaRepository<TelephoneComplaint, String> {
//	List<TelephoneComplaint> findByLocationAndStatus(String location, String status);
//	List<TelephoneComplaint> findByCreatedBy(Long id);
//	List<TelephoneComplaint> findByLocation(String loc);
//	List<TelephoneComplaint> findByLocationAndStatusNot(String loc, String string);
	List<TelephoneComplaint> findByLocationInAndStatus(List<String> location, String string);
//	List<TelephoneComplaint> findByLocationInAndStatusNot(List<String> location, String string);
	List<TelephoneComplaint> findByLocationIn(List<String> location);
}