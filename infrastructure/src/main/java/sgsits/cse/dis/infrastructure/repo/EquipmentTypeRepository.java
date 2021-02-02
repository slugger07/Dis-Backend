package sgsits.cse.dis.infrastructure.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.infrastructure.model.EquipmentType;

/**
 * <h1>EquipmentTypeRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 04-OCT-2020
 */

@Repository
public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, String> {

	Optional<EquipmentType> findByType(String type);

}
