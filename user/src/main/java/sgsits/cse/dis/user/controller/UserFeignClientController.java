package sgsits.cse.dis.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.user.serviceImpl.UserServicesImpl;

@Api("user Feign Client Controller")
@RestController
@RequestMapping(path = "/userFeignClientController")

public class UserFeignClientController {
	
	@Autowired
	private UserServicesImpl userServicesImpl;
	
	@ApiOperation(value = "get ID for given username", response = String.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getUserId", method = RequestMethod.GET)
	public String getUserId(@RequestParam("username") String username) {
		return userServicesImpl.getUserId(username);
	}
}
