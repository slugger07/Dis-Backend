package sgsits.cse.dis.infrastructure.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.infrastructure.model.Infrastructure;

@Repository("infrastructureRepository")
public interface InfrastructureRepository extends JpaRepository<Infrastructure, String> {
	List<Infrastructure> findByName(String name);
	List<Infrastructure> findByInchargeOrAssociateInchargeOrStaff(String id1, String id2, String id3);
}
