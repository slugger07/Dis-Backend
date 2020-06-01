package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.UserInternship;

@Repository()
public interface UserInternshipRepository extends JpaRepository<UserInternship, Long>{
	List<UserInternship> findByUserId(String id);
}
