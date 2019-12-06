package sgsits.cse.dis.administration.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.model.Event;
import sgsits.cse.dis.administration.model.EventParticipantsStaff;
import sgsits.cse.dis.administration.model.EventParticipantsStudent;
import sgsits.cse.dis.administration.repo.EventParticipantsStaffRepository;
import sgsits.cse.dis.administration.repo.EventParticipantsStudentRepository;
import sgsits.cse.dis.administration.repo.EventRepository;
import sgsits.cse.dis.administration.service.CalendarServices;

@Component
public class CalendarServicesImpl implements CalendarServices {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventParticipantsStaffRepository eventParticipanstStaffRepository;

	@Autowired
	private EventParticipantsStudentRepository eventParticipanstStudentRepository;

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
	public Event getEvent(String eventId) {
		Event event = eventRepository.findByEventId(eventId);
		return event;
	}

	@Override
	public void updateEvent(Event event) throws EventDoesNotExistException {
		if (getEvent(event.getEventId()) == null) {
			throw new EventDoesNotExistException("Event doesn't Exist");
		}
		eventRepository.save(event);
	}

	@Override
	public void deleteEvent(Event event) throws EventDoesNotExistException {
		if (getEvent(event.getEventId()) == null) {
			throw new EventDoesNotExistException("Event doesn't Exist");
		}
		eventRepository.delete(event);
	}

	@Override
	public List<Event> getStaffEvents(String participantId) {
		List<Event> eventList = new ArrayList<Event>();	
		List<EventParticipantsStaff> eventParticipantsStaffList = eventParticipanstStaffRepository.findByParticipantId(participantId);
		for (EventParticipantsStaff eventParticipantsStaff : eventParticipantsStaffList) {
			eventList.add(getEvent(eventParticipantsStaff.getEventId()));
		}
		return eventList;
	}

	@Override
	public List<Event> getStudentEvents(String participantId) {
		List<Event> eventList = new ArrayList<Event>();	
		List<EventParticipantsStudent> eventParticipantsStudentList = eventParticipanstStudentRepository.findByParticipantId(participantId);
		for (EventParticipantsStudent eventParticipantsStudent : eventParticipantsStudentList) {
			eventList.add(getEvent(eventParticipantsStudent.getEventId()));
		}
		return eventList;
	}

}
