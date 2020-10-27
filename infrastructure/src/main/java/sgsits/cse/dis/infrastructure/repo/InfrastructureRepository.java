package sgsits.cse.dis.infrastructure.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.infrastructure.model.Infrastructure;

@Repository("infrastructureRepository")
public interface InfrastructureRepository extends JpaRepository<Infrastructure, String> {
	List<Infrastructure> findByName(String name);
	List<Infrastructure> findByInchargeOrAssociateInchargeOrStaff(String id1, String id2, String id3);
	
	List<Infrastructure> findByTypeOrType(String type1, String Type2);
	List<Infrastructure> findByType(String type);
	
	@Modifying
	long deleteInfrastructureById(String id);
	List<Infrastructure> findByNameContainingIgnoreCase(String name);
}
