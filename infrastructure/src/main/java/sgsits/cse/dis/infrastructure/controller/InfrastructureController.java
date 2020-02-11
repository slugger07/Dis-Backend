package sgsits.cse.dis.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.infrastructure.constants.RestAPI;
import sgsits.cse.dis.infrastructure.exception.ConflictException;
import sgsits.cse.dis.infrastructure.feignClient.UserClient;
import sgsits.cse.dis.infrastructure.response.ActiveStaffListResponse;
import sgsits.cse.dis.infrastructure.response.InfrastructureBrief;
import sgsits.cse.dis.infrastructure.response.ResponseMessage;
import sgsits.cse.dis.infrastructure.service.InfrastructureService;

@CrossOrigin(origins = "*")
@Api(value = "Infrastructure resource controller")
@RestController
@RequestMapping(path = "/infrastructure")
public class InfrastructureController {

	@Autowired
	private InfrastructureService infrastructureService;
	
	@Autowired
	private UserClient userClient;
	
	@ApiOperation(value="Get list of locations", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_LIST_OF_INFRASTRUCTURE_LOCATIONS, produces = "application/json")
	public ResponseEntity<List<String>> getListOfInfrastructureLocations(){
		return new ResponseEntity<List<String>>( infrastructureService.getListOfInfrastructureLocations(),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get Infrastructure by type", response = InfrastructureBrief.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_INFRASTRUCTURE_BY_TYPE, produces = "application/json")
	public ResponseEntity<List<InfrastructureBrief>> getInfrastructureByType(@PathVariable("type") String type){
		return new ResponseEntity<List<InfrastructureBrief>>( infrastructureService.getInfrastructureByType(type),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get Infrastructure type list", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_INFRASTRUCTURE_TYPE, produces = "application/json")
	public ResponseEntity<List<String>> getInfrastructureTypeList(){
		return new ResponseEntity<List<String>>( infrastructureService.getInfrastructureTypeList(),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get Infrastructure type list", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path=RestAPI.ADD_NEW_INFRASTRUCTURE_LOCATION, produces = "application/json")
	public ResponseEntity<ResponseMessage> addNewInfrastructureLocation(@PathVariable("location") String location) throws ConflictException{
		return new ResponseEntity<ResponseMessage>( new ResponseMessage(infrastructureService.addNewInfrastructureLocation(location)),HttpStatus.OK);
	}
	
	@ApiOperation(value="Get list of active staff", response = ActiveStaffListResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_ACTIVE_STAFF_LIST, produces = "application/json")
	public ResponseEntity<List<ActiveStaffListResponse>> getActiveStaffList() throws NotFoundException{
		return new ResponseEntity<List<ActiveStaffListResponse>>(userClient.getActiveStaffList(),HttpStatus.OK);
	}
		
	
}
