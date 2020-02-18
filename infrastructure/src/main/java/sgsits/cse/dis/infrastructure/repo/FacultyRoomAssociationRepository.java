package sgsits.cse.dis.infrastructure.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.infrastructure.model.FacultyRoomAssociation;
/**
 * <h1>FacultyRoomAssociationRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 25-JAN-2020
 */
public interface FacultyRoomAssociationRepository extends JpaRepository<FacultyRoomAssociation, String> {

	List<FacultyRoomAssociation> findByRoomId(String name);

}
