package sgsits.cse.dis.infrastructure.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.infrastructure.model.InfrastructureLocation;
/**
 * <h1>InfrastructureLocationRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 25-JAN-2020
 */
public interface InfrastructureLocationRepository extends  JpaRepository<InfrastructureLocation, String> {

}
