package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.UserResearchWork;

@Repository("userResearchWorkRepository")
public interface UserResearchWorkRepository extends JpaRepository<UserResearchWork, Long>{
	List<UserResearchWork> findByUserId(Long id);
}
