package sgsits.cse.dis.administration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.model.Event;
import sgsits.cse.dis.administration.repo.EventRepository;
import sgsits.cse.dis.administration.service.CalendarServices;

@Component
public class CalenderServicesImpl implements CalendarServices {
	
	@Autowired 
	EventRepository eventRepository;
	
	@Override
	public List<Event> getAllEvents() {
		List<Event> eventList = eventRepository.findAll();
		return eventList;
	}
	
	@Override
	public void addEvent(Event event) {
		eventRepository.save(event);
	}

	@Override
	public Event getEvent(Long eventId) {
		Event event = eventRepository.findByEventId(eventId);
		return event;
	}

	@Override
	public void updateEvent(Event event) throws EventDoesNotExistException {
		if(getEvent(event.getEventId())==null) {
			throw new EventDoesNotExistException("Event doesn't Exist");
		}
		eventRepository.save(event);
	}

	@Override
	public void deleteEvent(Event event) throws EventDoesNotExistException{
		if(getEvent(event.getEventId())==null) {
			throw new EventDoesNotExistException("Event doesn't Exist");
		}
		eventRepository.delete(event);
	}

	@Override
	public List<Event> getEvents(int userId) {
		
		return null;
	}



}
