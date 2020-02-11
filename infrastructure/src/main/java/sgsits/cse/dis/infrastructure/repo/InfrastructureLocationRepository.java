package sgsits.cse.dis.infrastructure.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.infrastructure.model.InfrastructureLocation;

public interface InfrastructureLocationRepository extends  JpaRepository<InfrastructureLocation, String> {

}
