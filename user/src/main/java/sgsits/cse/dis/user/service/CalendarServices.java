package sgsits.cse.dis.user.service;

import java.rmi.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;

import com.sun.mail.util.MailConnectException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import sgsits.cse.dis.user.exception.EventDoesNotExistException;
import sgsits.cse.dis.user.model.Event;
import sgsits.cse.dis.user.model.Holiday;

@Component
public interface CalendarServices {
	Event addEvent(MultipartFile attachment,Event event) throws SQLException, MessagingException, MailConnectException, UnknownHostException;
	Event updateEvent(Event event,String eventId) throws SQLException, MessagingException, EventDoesNotExistException, MailConnectException, UnknownHostException;
	void deleteEvent(String eventId) throws SQLException, MessagingException,EventDoesNotExistException, MailConnectException, UnknownHostException;
	Event getEvent(String eventId);
	List<Event>  getAllEvents();
	List<Event> getMyEvents(String participantId);
	List<Holiday> getPublicHolidays();
}
