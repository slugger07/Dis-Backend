package sgsits.cse.dis.administration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.Event;

@Repository("")
public interface EventRepository extends JpaRepository<Event, Long>{
	
	Event findByEventId(Long eventId);
	
}
