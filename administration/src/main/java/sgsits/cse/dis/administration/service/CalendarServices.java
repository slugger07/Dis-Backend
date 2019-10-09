package sgsits.cse.dis.administration.service;

import java.util.List;

import org.springframework.stereotype.Component;

import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.model.Event;

@Component
public interface CalendarServices {
	void addEvent(Event event);
	List<Event> getEvents(int userId);
	void updateEvent(Event event) throws EventDoesNotExistException;
	void deleteEvent(Event event) throws EventDoesNotExistException;
	Event getEvent(Long eventId);
	List<Event>  getAllEvents();
}
