package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.dtos.EventDto;
import sgsits.cse.dis.user.model.Event;
import java.util.List;

@Repository()
public interface EventRepository extends JpaRepository<Event, String>{

	Event findByEventId(String eventId);
	List<Event> findAllByParticipants_ParticipantId(String participantId);
}
