package sgsits.cse.dis.administration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.model.Event;
import sgsits.cse.dis.administration.serviceImpl.CalendarServicesImpl;

@Api(value = "Library services controller")
@RestController
@RequestMapping(path = "/calendar")
public class CalendarController {

	@Autowired
	private CalendarServicesImpl calenderServiceImpl;
		

	private List<Event> eventList;

	@ApiOperation(value="Get all the events", response= Event.class, httpMethod = "GET", produces="application/json")
	@GetMapping(path = "/getAllEvents", produces = "application/json")
	//@PreAuthorize("hasRole('NBA')")
	@ResponseBody
	public List<Event> getAllEvents(){
		List<Event> eventList = calenderServiceImpl.getAllEvents();
		return eventList;
	}

	@ApiOperation(value="Get staff events", response= Event.class, httpMethod = "GET", produces="application/json")
	@GetMapping(path = "/getStaffEvents", produces = "application/json")
	@ResponseBody
	public List<Event> getStaffEvents(@RequestParam String id) {
		List<Event> eventList = calenderServiceImpl.getStaffEvents(id);
	
		return eventList;
	}

	@ApiOperation(value="Get student events", response= Event.class, httpMethod = "GET", produces="application/json")
	@GetMapping(path = "/getStudentEvents", produces = "application/json")
	@ResponseBody
	public List<Event> getStudentEvents(@RequestParam String id) {
		eventList = calenderServiceImpl.getStudentEvents(id);
		eventList.addAll(calenderServiceImpl.getStudentEvents("all"));
		return eventList;
	}
	
	
	@ApiOperation(value="Add an event", response= Event.class, httpMethod = "POST", produces="application/json")
	@PostMapping(path = "/addEvent", produces = "application/json")
	//@PreAuthorize("hasAuthority('NBA')")
	public void addEvent(@RequestBody Event event) {
		calenderServiceImpl.addEvent(event);
	}
	
	@ApiOperation(value="Delete an event", response= Event.class, httpMethod = "GET", produces="application/json")
	@GetMapping(path = "/deleteEvent", produces = "application/json")
	public void deleteEvent(@RequestParam  String id) throws EventDoesNotExistException {
		Event to_be_deleted = calenderServiceImpl.getEvent(id);
		calenderServiceImpl.deleteEvent(to_be_deleted);
	}
	
	@ApiOperation(value="Update an event", response= Event.class, httpMethod = "POST", produces="application/json")
	@PostMapping(path = "/updateEvent", produces = "application/json")
	public void updateEvent(@RequestBody Event event) throws EventDoesNotExistException {
		calenderServiceImpl.updateEvent(event);
	}
}
