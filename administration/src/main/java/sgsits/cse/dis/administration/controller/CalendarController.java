package sgsits.cse.dis.administration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgsits.cse.dis.administration.model.Event;
import sgsits.cse.dis.administration.serviceImpl.CalenderServicesImpl;

@RestController
@RequestMapping(path = "/calendar")
public class CalendarController {
	
	@Autowired CalenderServicesImpl calenderServices;
	
	@GetMapping(path="/getAllEvents", produces = "application/json")
    public List<Event> getEmployees()
    {
        return calenderServices.getAllEvents();
    }
     
	/*
	 * @PostMapping(path= "/", consumes = "application/json", produces =
	 * "application/json") public ResponseEntity<Object> addEmployee(@RequestBody
	 * Employee employee) { Integer id =
	 * employeeDao.getAllEmployees().getEmployeeList().size() + 1;
	 * employee.setId(id);
	 * 
	 * employeeDao.addEmployee(employee);
	 * 
	 * URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	 * .path("/{id}") .buildAndExpand(employee.getId()) .toUri();
	 * 
	 * return ResponseEntity.created(location).build(); }
	 */
}
