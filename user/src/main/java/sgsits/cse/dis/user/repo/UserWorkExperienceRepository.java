package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.UserWorkExperience;

@Repository()
public interface UserWorkExperienceRepository extends JpaRepository<UserWorkExperience, Long>{
	List<UserWorkExperience> findByUserId(String id);

}
