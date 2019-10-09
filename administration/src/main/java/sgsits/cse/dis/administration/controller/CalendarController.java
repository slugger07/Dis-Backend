package sgsits.cse.dis.administration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgsits.cse.dis.administration.model.Event;
import sgsits.cse.dis.administration.service.CalendarServices;

@RestController
@RequestMapping(path = "/calendar")
public class CalendarController {
	
	@Autowired CalendarServices calenderServices;
	
	@GetMapping(path="/getAllEvents", produces = "application/json")
    public List<Event> getEmployees()
    {
        return calenderServices.getAllEvents();
    }
     
}
