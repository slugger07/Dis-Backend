package sgsits.cse.dis.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.exception.EventDoesNotExistException;
import sgsits.cse.dis.user.model.Event;
import sgsits.cse.dis.user.model.EventParticipant;
import sgsits.cse.dis.user.repo.EventParticipantRepository;
import sgsits.cse.dis.user.repo.EventRepository;
import sgsits.cse.dis.user.repo.UserRepository;
import sgsits.cse.dis.user.service.CalendarServices;

@Service
public class CalendarServicesImpl implements CalendarServices {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> getAllEvents() {
		List<Event> eventList = eventRepository.findAll();
		return eventList;
	}

	@Override
	public Event addEvent(Event event) {
		eventRepository.save(event);
		return event;
	}

	@Override
	public Event getEvent(String eventId) {
		Event event = eventRepository.findByEventId(eventId);
		return event;
	}

	@Override
	public Event updateEvent(Event event) throws EventDoesNotExistException {
		String eventId = event.getEventId();
		if (getEvent(eventId) == null) {
			throw new EventDoesNotExistException("Event doesn't Exist");
		}
		eventRepository.deleteById(eventId);
		eventRepository.save(event);
		return event;
	}

	@Override
	public void deleteEvent(String eventId) throws EventDoesNotExistException {
		Event to_be_deleted = getEvent(eventId);
		if (to_be_deleted == null) {
			throw new EventDoesNotExistException("Event doesn't Exist");
		}
		eventRepository.delete(to_be_deleted);
	}

	@Override
	public List<Event> getMyEvents(String participantId) {
		List<Event> eventList = new ArrayList<Event>();
		List<Event> eventParticipantsList = eventRepository.findAllByParticipants_ParticipantId(participantId);
		for (Event eventParticipants : eventParticipantsList) {
			eventList.add(getEvent(eventParticipants.getEventId()));
		}
		return eventList;
	}

}
