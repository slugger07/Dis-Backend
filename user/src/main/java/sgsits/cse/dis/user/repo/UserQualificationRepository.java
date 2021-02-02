package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.UserQualification;

@Repository()
public interface UserQualificationRepository extends JpaRepository<UserQualification, Long>{
	
	List<UserQualification> findByUserId(String id);

}
