package sgsits.cse.dis.infrastructure.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.infrastructure.model.InfrastructureType;
/**
 * <h1>InfrastructureTypeRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 25-JAN-2020
 */
public interface InfrastructureTypeRepository extends JpaRepository<InfrastructureType, String> {

}
