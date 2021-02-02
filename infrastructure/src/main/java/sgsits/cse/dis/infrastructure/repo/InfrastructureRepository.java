package sgsits.cse.dis.infrastructure.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;



import sgsits.cse.dis.infrastructure.model.Infrastructure;
/**
 * <h1>InfrastructureRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 25-JAN-2020
 */
@Repository("infrastructureRepository")
public interface InfrastructureRepository extends JpaRepository<Infrastructure, String> {
	List<Infrastructure> findByName(String name);
	List<Infrastructure> findByInchargeOrAssociateInchargeOrStaff(long id1, long id2, long id3);
	List<Infrastructure> findByTypeOrType(String type1, String Type2);
	List<Infrastructure> findByType(String type);
	
	@Modifying
	long deleteInfrastructureById(String id);
	List<Infrastructure> findByNameContainingIgnoreCase(String name);
}
