package sgsits.cse.dis.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.user.exception.EventDoesNotExistException;
import sgsits.cse.dis.user.model.Event;
import sgsits.cse.dis.user.serviceImpl.CalendarServicesImpl;

@CrossOrigin(origins = "*")
@Api(value = "Calendar services controller")
@RestController
@RequestMapping(path = "/calendar")
public class CalendarController {

	@Autowired
	private CalendarServicesImpl calenderServiceImpl;
		
	private List<Event> eventList;

	@ApiOperation(value="Get all the events", response= Event.class, httpMethod = "GET", produces="application/json")
	@GetMapping(path = "/getAllEvents", produces = "application/json")
	@ResponseBody
	public List<Event> getAllEvents(){
		List<Event> eventList = calenderServiceImpl.getAllEvents();
		return eventList;
	}


	@ApiOperation(value="Get my events", response= Event.class, httpMethod = "GET", produces="application/json")
	@GetMapping(path = "/getMyEvents", produces = "application/json")
	@ResponseBody
	public List<Event> getMyEvents(@RequestParam String id) {
		List<Event> eventList = calenderServiceImpl.getMyEvents(id);
		return eventList;
	}

//	@ApiOperation(value="Get student events", response= Event.class, httpMethod = "GET", produces="application/json")
//	@GetMapping(path = "/getStudentEvents", produces = "application/json")
//	@ResponseBody
//	public List<Event> getStudentEvents(@RequestParam String id) {
//		eventList = calenderServiceImpl.getStudentEvents(id);
//		eventList.addAll(calenderServiceImpl.getStudentEvents("all"));
//		return eventList;
//	}
	
	
	@ApiOperation(value="Add an event", response= Event.class, httpMethod = "POST", produces="application/json")
	@PostMapping(path = "/addEvent", produces = "application/json")
	public void addEvent(@RequestBody Event event) {
		calenderServiceImpl.addEvent(event);
	}
	
	@ApiOperation(value="Delete an event", response= Event.class, httpMethod = "GET", produces="application/json")
	@GetMapping(path = "/deleteEvent", produces = "application/json")
	public void deleteEvent(@RequestParam  String eventId) throws EventDoesNotExistException {
		calenderServiceImpl.deleteEvent(eventId);
	}
	
	@ApiOperation(value="Update an event", response= Event.class, httpMethod = "POST", produces="application/json")
	@PostMapping(path = "/updateEvent", produces = "application/json")
	public void updateEvent(@RequestBody Event event) throws EventDoesNotExistException {
		calenderServiceImpl.updateEvent(event);
	}
}
