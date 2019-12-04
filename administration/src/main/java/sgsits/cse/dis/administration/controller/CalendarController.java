package sgsits.cse.dis.administration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.model.Event;
import sgsits.cse.dis.administration.service.CalendarServices;
import sgsits.cse.dis.administration.serviceImpl.CalendarServicesImpl;

@RestController
@RequestMapping(path = "/calendar")
public class CalendarController {

	@Autowired
	CalendarServicesImpl calenderServiceImpl;
		

	List<Event> eventList;

	@GetMapping(path = "/getAllEvents", produces = "application/json")
	@ResponseBody
	public List<Event> getAllEvents(){
		List<Event> eventList = calenderServiceImpl.getAllEvents();
		return eventList;
	}

	@GetMapping(path = "/getStaffEvents", produces = "application/json")
	@ResponseBody
	public List<Event> getStaffEvents(@RequestParam String id) {
		List<Event> eventList = calenderServiceImpl.getStaffEvents(id);
	
		return eventList;
	}

	@GetMapping(path = "/getStudentEvents", produces = "application/json")
	@ResponseBody
	public List<Event> getStudentEvents(@RequestParam String id) {
		eventList = calenderServiceImpl.getStudentEvents(id);
		eventList.addAll(calenderServiceImpl.getStudentEvents("all"));
		return eventList;
	}
	
	@PostMapping(path = "/addEvent", produces = "application/json")
	public void addEvent(@RequestBody Event event) {
		calenderServiceImpl.addEvent(event);
	}
	
	@GetMapping(path = "/deleteEvent", produces = "application/json")
	public void deleteEvent(@RequestParam  String id) throws EventDoesNotExistException {
		Event to_be_deleted = calenderServiceImpl.getEvent(id);
		calenderServiceImpl.deleteEvent(to_be_deleted);
	}
	
	@PostMapping(path = "/updateEvent", produces = "application/json")
	public void updateEvent(@RequestBody Event event) throws EventDoesNotExistException {
		calenderServiceImpl.updateEvent(event);
	}
}
