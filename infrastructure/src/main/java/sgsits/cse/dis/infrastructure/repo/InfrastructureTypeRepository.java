package sgsits.cse.dis.infrastructure.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.infrastructure.model.InfrastructureType;

public interface InfrastructureTypeRepository extends JpaRepository<InfrastructureType, String> {

}
