package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.UserIntenship;

@Repository("userInternshipRepository")
public interface UserInternshipRepository extends JpaRepository<UserIntenship, Long>{
	List<UserIntenship> findByUserId(Long id);
}
