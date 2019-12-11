package sgsits.cse.dis.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.user.serviceImpl.UserServicesImpl;

@Api(value = "User Feign Client Controller")
@RestController
@RequestMapping(path = "/userFeignClientController")
public class UserFeignClientController {

	@Autowired
	private UserServicesImpl userServicesImpl;
	
	@ApiOperation(value="Verify username", response = boolean.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = "/existsByUsername/{username}")
	public boolean existsByUsername(@PathVariable("username") String username) throws NotFoundException {
		return userServicesImpl.existsByUsername(username);
	}
}
