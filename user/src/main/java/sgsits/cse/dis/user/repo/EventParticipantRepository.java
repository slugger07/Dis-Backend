package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.Event;
import sgsits.cse.dis.user.model.EventParticipant;


@Repository
public interface EventParticipantRepository extends JpaRepository<EventParticipant, String> {

}