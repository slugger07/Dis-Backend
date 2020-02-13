package sgsits.cse.dis.infrastructure.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sgsits.cse.dis.infrastructure.model.FacultyRoomAssociation;

public interface FacultyRoomAssociationRepository extends JpaRepository<FacultyRoomAssociation, String> {

	List<FacultyRoomAssociation> findByRoomId(String name);

}
