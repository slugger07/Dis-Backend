package sgsits.cse.dis.user.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.exception.EventDoesNotExistException;
import sgsits.cse.dis.user.model.Event;

@Component
public interface CalendarServices {
	Event addEvent(Event event);
	Event updateEvent(Event event) throws EventDoesNotExistException;
	void deleteEvent(String eventId) throws EventDoesNotExistException;
	Event getEvent(String eventId);
	List<Event>  getAllEvents();
	List<Event> getMyEvents(String participantId);
}
