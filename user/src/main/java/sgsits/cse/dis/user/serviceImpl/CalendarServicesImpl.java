package sgsits.cse.dis.user.serviceImpl;

import java.rmi.UnknownHostException;
import java.util.*;

import com.sun.mail.util.MailConnectException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.controller.EmailController;
import sgsits.cse.dis.user.controller.StaffController;
import sgsits.cse.dis.user.exception.EventDoesNotExistException;
import sgsits.cse.dis.user.model.Event;
import sgsits.cse.dis.user.model.EventParticipant;
import sgsits.cse.dis.user.model.Holiday;
import sgsits.cse.dis.user.repo.*;
import sgsits.cse.dis.user.service.CalendarServices;

import javax.swing.text.html.HTMLDocument;

@Service
public class CalendarServicesImpl implements CalendarServices {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private HolidayRepository holidayRepository;

	@Autowired
	private StaffBasicProfileRepository staffBasicProfileRepository;

	@Autowired
	EmailController email;

	@Override
	public List<Event> getAllEvents() {
		List<Event> eventList = eventRepository.findAll();
		return eventList;
	}

	@Override
	public Event addEvent(Event event) throws MailConnectException, UnknownHostException {
		eventRepository.save(event);
		ArrayList<String> mailing_list = new ArrayList<String>();
		for(EventParticipant participant: event.getParticipants()) {
			mailing_list.add(participant.getParticipantId());
		}
		sendMeetingInvites(mailing_list, "add",event);
		return event;
	}

	@Override
	public Event getEvent(String eventId) {
		Event event = eventRepository.findByEventId(eventId);
		return event;
	}

	@Override
	public Event updateEvent(Event event,String eventId) throws EventDoesNotExistException, MailConnectException, UnknownHostException {
		System.out.println(eventId);
		System.out.println(event.getEventId());
		if (eventId == null) {
			throw new EventDoesNotExistException("Event doesn't Exist");
			}
		Event old_event = eventRepository.findByEventId(eventId);
		Set<String> old_participants = new HashSet<>();
		Set<String> new_participants = new HashSet<>();

		for (EventParticipant eventParticipant : old_event.getParticipants())
			old_participants.add(eventParticipant.getParticipantId());

		for (EventParticipant eventParticipant : event.getParticipants())
			new_participants.add(eventParticipant.getParticipantId());

		Set<String> retainedParticipants = new HashSet<>(old_participants);
		retainedParticipants.retainAll(new_participants);
		Set<String> removedParticipants = new HashSet<>(old_participants);
		removedParticipants.removeAll(new_participants);
		Set<String> newParticipants = new HashSet<>(new_participants);
		newParticipants.removeAll(old_participants);
		eventRepository.deleteById(eventId);
		eventRepository.save(event);

		if(!retainedParticipants.isEmpty()) {
			sendMeetingInvites(new ArrayList<String>(retainedParticipants), "update", event);
		}
		if(!removedParticipants.isEmpty()) {
			sendMeetingInvites(new ArrayList<String>(removedParticipants), "cancel", event);
		}
		if(!newParticipants.isEmpty()) {
			sendMeetingInvites(new ArrayList<String>(newParticipants), "add", event);
		}

		return event;
	}

	@Override
	public void deleteEvent(String eventId) throws EventDoesNotExistException, MailConnectException, UnknownHostException {
		if (eventId==null) {
			throw new EventDoesNotExistException("Event doesn't Exist");
		}
		Event event = getEvent(eventId);
		Set<EventParticipant> removedParticipants = event.getParticipants();
		ArrayList<String> mailing_list = new ArrayList<String>();
		eventRepository.deleteById(eventId);
		for(EventParticipant participant: removedParticipants) {
			mailing_list.add(participant.getParticipantId());
		}
		sendMeetingInvites(mailing_list, "cancel", event);
	}

	@Override
	public List<Holiday> getPublicHolidays() {
		List<Holiday> holiday = holidayRepository.findAll();
		return holiday;
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

	private void sendMeetingInvites(ArrayList<String> username_list, String mail_type, Event event) throws MailConnectException, UnknownHostException {
		String type;
		ArrayList<String> mailing_list = new ArrayList<String>();
		List<Object[]> staffData = staffBasicProfileRepository.findAllUserIdAndEmails();
		for(Object[] staff_member: staffData) {
			if(username_list.contains(staff_member[0])) {
				mailing_list.add((String) staff_member[1]);
			}
		}
		String startLine  = "You have been invited to the following event.\n\n";
		if(mail_type.equals("add")) {
			type = "Invitation";
		} else if(mail_type.equals("update")) {
			startLine  = "Following event was updated by the organizer.\n\n";
			type = "Updated Invitation";
		} else {
			startLine  = "Following event has been cancelled by the organizer.\n\n";
			type = "Cancelled event";
		}

		String organizer = staffBasicProfileRepository.findNameByUsername(event.getEventIncharge());

		email.sendSimpleEmail(type + " : "+event.getTitle()+"@ "+event.getStartDate().toString(),
				startLine +
						"For : " + event.getTitle()+ "\n" +
						"When : "+ event.getStartDate().toString() + "\n" +
						"Where : "+ event.getLocation() + "\n" +
						"Agenda : " + event.getDescription()+ "\n" +
						"Organizer : " + organizer+ "\n", mailing_list.toArray(new String[0]));

	}
}
