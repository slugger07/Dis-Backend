package sgsits.cse.dis.administration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import sgsits.cse.dis.administration.model.Event;
import sgsits.cse.dis.administration.service.CalendarServices;

@Api(value = "Library services controller")
@RestController
@RequestMapping(path = "/calendar")
public class CalendarController {

	@Autowired
	CalendarServices calenderServices;
		

	List<Event> eventList;

	@GetMapping(path = "/getAllEvents", produces = "application/json")
	@ResponseBody
	public List<Event> getAllEvents(@RequestParam Long id){
		List<Event> eventList = calenderServices.getAllEvents();
		return eventList;
	}

	@GetMapping(path = "/getStaffEvents", produces = "application/json")
	@ResponseBody
	public List<Event> getStaffEvents(@RequestParam String id) {
		List<Event> eventList = calenderServices.getStaffEvents(id);
	
		return eventList;
	}

	@GetMapping(path = "/getStudentEvents", produces = "application/json")
	@ResponseBody
	public List<Event> getStudentEvents(@RequestParam String id) {
		eventList = calenderServices.getStudentEvents(id);
		eventList.addAll(calenderServices.getStudentEvents("all"));
		return eventList;
	}
	
}
