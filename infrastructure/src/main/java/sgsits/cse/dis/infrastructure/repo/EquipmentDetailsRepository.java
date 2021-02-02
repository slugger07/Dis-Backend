package sgsits.cse.dis.infrastructure.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.infrastructure.model.EquipmentDetails;

/**
 * <h1>EquipmentDetailsRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 04-OCT-2020
 */

@Repository
public interface EquipmentDetailsRepository extends JpaRepository<EquipmentDetails, String> {

	long deleteEquipmentDetailById(String id);

	List<EquipmentDetails> findByEquipmentType(String type);

	List<EquipmentDetails> findByRoomNameContaining(String lab);

	List<EquipmentDetails> findByRoomNameContainingAndEquipmentTypeContaining(String lab, String type);

}
