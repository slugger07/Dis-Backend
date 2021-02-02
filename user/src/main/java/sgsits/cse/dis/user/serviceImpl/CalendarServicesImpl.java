package sgsits.cse.dis.user.serviceImpl;

import java.io.IOException;
import java.rmi.UnknownHostException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.user.controller.EmailController;
import sgsits.cse.dis.user.controller.UserNotificationController;
import sgsits.cse.dis.user.dtos.EventDto;
import sgsits.cse.dis.user.exception.EventDoesNotExistException;
import sgsits.cse.dis.user.model.*;
import sgsits.cse.dis.user.repo.*;
import sgsits.cse.dis.user.service.CalendarServices;
import sgsits.cse.dis.user.service.NotificationService;

import javax.mail.MessagingException;

@Service
public class CalendarServicesImpl implements CalendarServices {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private HolidayRepository holidayRepository;

	@Autowired
	private StaffBasicProfileRepository staffBasicProfileRepository;

	@Autowired
	EmailController email;

	@Autowired
	NotificationService notification;

	@Override
	public List<Event> getAllEvents() {
		List<Event> eventList = eventRepository.findAll();
		return eventList;
	}

	@Override
	public Event addEvent(EventDto event, MultipartFile[] files) throws IOException, MessagingException, SQLException {
		Event conv_event = convertDtoToEventModel(event, files);
		eventRepository.save(conv_event);
		ArrayList<String> mailing_list = new ArrayList<String>();
		for(EventParticipant participant: event.getParticipants()) {
			mailing_list.add(participant.getParticipantId());
		}
		sendMeetingInvites(mailing_list, "add",conv_event);
		generateNotification(conv_event, "add", mailing_list);
		return conv_event;
	}

	@Override
	public Event getEvent(String eventId) {
		Event event = eventRepository.findByEventId(eventId);
		return event;
	}

	@Override
	public Event updateEvent(EventDto event,String eventId, MultipartFile[] files) throws EventDoesNotExistException, IOException, MessagingException, SQLException {
		if (eventId == null) {
			throw new EventDoesNotExistException("Event doesn't Exist");
			}
		Event conv_event = convertDtoToEventModel(event, files);
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
		eventRepository.save(conv_event);

		if(!retainedParticipants.isEmpty()) {
			sendMeetingInvites(new ArrayList<String>(retainedParticipants), "update", conv_event);
			generateNotification(conv_event, "update", new ArrayList<String>(retainedParticipants));
		}
		if(!removedParticipants.isEmpty()) {
			old_event.setAttachments(null);
			sendMeetingInvites(new ArrayList<String>(removedParticipants), "cancel", old_event);
			generateNotification(old_event, "cancel", new ArrayList<String>(removedParticipants));
		}
		if(!newParticipants.isEmpty()) {
			sendMeetingInvites(new ArrayList<String>(newParticipants), "add", conv_event);
			generateNotification(conv_event, "add", new ArrayList<String>(newParticipants));
		}

		return conv_event;
	}

	@Override
	public void deleteEvent(String eventId) throws EventDoesNotExistException, IOException, MessagingException, SQLException {
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
		event.setAttachments(null);
		sendMeetingInvites(mailing_list, "cancel", event);
		generateNotification(event, "cancel", mailing_list);
	}

	@Override
	public List<Holiday> getPublicHolidays() {
		List<Holiday> holiday = holidayRepository.findAll();
		return holiday;
	}

	@Override
	public Group addGroup(Group group) {
		groupRepository.save(group);
		return group;
	}

	@Override
	public List<Group> getMyGroups(String username) {
		return groupRepository.findByCreatedBy(username);
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

	private void sendMeetingInvites(ArrayList<String> username_list, String mail_type, Event event) throws UnknownHostException, MessagingException, SQLException {
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
						"Organizer : " + organizer+
						"\n", event.getAttachments(), mailing_list.toArray(new String[0]));

	}

	private void generateNotification(Event event, String notification_type, List<String> username_list) {
		String type;
		String organizer = staffBasicProfileRepository.findNameByUsername(event.getEventIncharge());
		Notification newNotification = new Notification();

		String startLine  = "You have been invited to the following event.\n\n";
		if(notification_type.equals("add")) {
			type = "Invitation";
		} else if(notification_type.equals("update")) {
			startLine  = "Following event was updated by the organizer.\n\n";
			type = "Updated Invitation";
		} else {
			startLine  = "Following event has been cancelled by the organizer.\n\n";
			type = "Cancelled event";
		}

		newNotification.setHeading(type + " : "+ event.getTitle()+"@ "+event.getStartDate().toString());
		newNotification.setDescription(startLine +"For : " + event.getTitle()+ "\n" +
				"When : "+ event.getStartDate().toString() + "\n" +
				"Where : "+ event.getLocation() + "\n" +
				"Agenda : " + event.getDescription()+ "\n" +
				"Organizer : " + organizer);
		notification.sendNotificationToParticipants(newNotification, username_list);
	}

	private Event convertDtoToEventModel(EventDto event, MultipartFile[] files) throws IOException {
		Event eventModel = new Event();
		eventModel.setEventId(event.getEventId());
		eventModel.	setCreatedBy(event.getCreatedBy());
		eventModel.setCreatedDate(event.getCreatedDate());
		eventModel.setTitle(event.getTitle());
		eventModel.setDescription(event.getDescription());
		eventModel.setStartDate(event.getStartDate());
		eventModel.setEndDate(event.getEndDate());
		eventModel.setEventIncharge(event.getEventIncharge());
		eventModel.setParticipants(event.getParticipants());
		eventModel.setLocation(event.getLocation());

		if (files != null) {
			if(files.length > 0) {
				Set<EventAttachment> eventAttachmentSet = new HashSet<EventAttachment>();
				for (MultipartFile aFile : files) {

					System.out.println("Saving file: " + aFile.getOriginalFilename());

					EventAttachment attach = new EventAttachment();
					attach.setFileName(aFile.getOriginalFilename());
					attach.setFileData(aFile.getBytes());
					eventAttachmentSet.add(attach);
				}
				eventModel.setAttachments(eventAttachmentSet);
			}
		}
		return eventModel;
	}
}
