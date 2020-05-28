package sgsits.cse.dis.administration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.CWNComplaint;
//CWN Maintenance

@Repository("")
public interface CWNComplaintRepository extends JpaRepository<CWNComplaint, String> {
	List<CWNComplaint> findByLocationInAndStatus(List<String> location, String string);
	List<CWNComplaint> findByLocationIn(List<String> location);
}