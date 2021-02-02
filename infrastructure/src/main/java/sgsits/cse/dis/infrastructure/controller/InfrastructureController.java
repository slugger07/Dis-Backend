package sgsits.cse.dis.infrastructure.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.infrastructure.constants.RestAPI;
import sgsits.cse.dis.infrastructure.exception.ConflictException;
import sgsits.cse.dis.infrastructure.feignClient.UserClient;
import sgsits.cse.dis.infrastructure.jwt.JwtResolver;
import sgsits.cse.dis.infrastructure.model.Infrastructure;
import sgsits.cse.dis.infrastructure.request.UpdateInfraInchargeDetail;
import sgsits.cse.dis.infrastructure.response.FacultyNameListResponse;
import sgsits.cse.dis.infrastructure.response.InfrastructureBrief;
import sgsits.cse.dis.infrastructure.response.InfrastructureInchargeResponse;
import sgsits.cse.dis.infrastructure.response.ResponseMessage;
import sgsits.cse.dis.infrastructure.response.RoomAssociationData;
import sgsits.cse.dis.infrastructure.service.InfrastructureService;

@CrossOrigin(origins = "*")
@Api(value = "Infrastructure resource controller")
@RestController
@RequestMapping(path = "/infrastructure")
public class InfrastructureController {

	private JwtResolver jwtResolver = new JwtResolver();

	@Autowired
	private InfrastructureService infrastructureService;

	@Autowired
	private UserClient userClient;

	@ApiOperation(value = "Get list of locations", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_LIST_OF_INFRASTRUCTURE_LOCATIONS, produces = "application/json")
	public ResponseEntity<List<String>> getListOfInfrastructureLocations() {
		return new ResponseEntity<List<String>>(infrastructureService.getListOfInfrastructureLocations(),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Get Infrastructure by type", response = InfrastructureBrief.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_INFRASTRUCTURE_BY_TYPE, produces = "application/json")
	public ResponseEntity<List<InfrastructureBrief>> getInfrastructureByType(@PathVariable("type") String type) {
		return new ResponseEntity<List<InfrastructureBrief>>(infrastructureService.getInfrastructureByType(type),
				HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get All Infrastructure", response = InfrastructureBrief.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_ALL_INFRASTRUCTURE, produces = "application/json")
	public ResponseEntity<List<InfrastructureBrief>> getAllInfrastructure() {
		return new ResponseEntity<List<InfrastructureBrief>>(infrastructureService.getAllInfrastructure(),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Get Infrastructure type list", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_INFRASTRUCTURE_TYPE, produces = "application/json")
	public ResponseEntity<List<String>> getInfrastructureTypeList() {
		return new ResponseEntity<List<String>>(infrastructureService.getInfrastructureTypeList(), HttpStatus.OK);
	}

	@ApiOperation(value = "Add new location for infrastructure", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path = RestAPI.ADD_NEW_INFRASTRUCTURE_LOCATION, produces = "application/json")
	public ResponseEntity<ResponseMessage> addNewInfrastructureLocation(@PathVariable("location") String location)
			throws ConflictException {
		return new ResponseEntity<ResponseMessage>(
				new ResponseMessage(infrastructureService.addNewInfrastructureLocation(location)), HttpStatus.OK);
	}

	@ApiOperation(value = "Get staff name list", response = FacultyNameListResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_STAFF_NAME_LIST, produces = "application/json")
	public ResponseEntity<List<FacultyNameListResponse>> getStaffData() {
		return new ResponseEntity<List<FacultyNameListResponse>>(
				userClient.getStaffNameList().stream()
						.map(faculty -> new FacultyNameListResponse(faculty.getId(), faculty.getName()))
						.sorted(Comparator.comparing(FacultyNameListResponse::getName)).collect(Collectors.toList()),
				HttpStatus.OK);

	}

	@ApiOperation(value = "Get faculty name list", response = FacultyNameListResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_FACULTY_NAME_LIST, produces = "application/json")
	public ResponseEntity<List<FacultyNameListResponse>> getFacultyData() {
		return new ResponseEntity<List<FacultyNameListResponse>>(
				userClient.getFacultyNameList().stream()
						.map(faculty -> new FacultyNameListResponse(faculty.getId(), faculty.getName()))
						.sorted(Comparator.comparing(FacultyNameListResponse::getName)).collect(Collectors.toList()),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Add new infrastructure", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path = RestAPI.ADD_NEW_INFRASTRUCTURE, produces = "application/json")
	public ResponseEntity<ResponseMessage> addNewInfrastructure(@RequestBody @Valid Infrastructure infrastructure,
			HttpServletRequest request) throws ConflictException {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(infrastructureService.addNewInfrastructure(
				infrastructure, jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")))), HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Infrastructure", response = ResponseMessage.class, httpMethod = "DELETE", produces = "application/json")
	@DeleteMapping(path = RestAPI.DELETE_INFRASTRUCTURE, produces = "application/json")
	public ResponseEntity<ResponseMessage> deleteInfrastructure(@PathVariable("id") String id)
			throws ConflictException {
		infrastructureService.deleteInfrastructure(id);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Deleted sucessufully"), HttpStatus.OK);
	}

	@ApiOperation(value = "Update Infrastructure", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path = RestAPI.UPDATE_INFRASTRUCTURE, produces = "application/json")
	public ResponseEntity<ResponseMessage> updateInfrastructure(@RequestBody Infrastructure infrastructure,
			HttpServletRequest request) throws ConflictException {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(infrastructureService.updateInfrastructure(
				infrastructure, jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")))), HttpStatus.OK);
	}

	@ApiOperation(value = "find Infrastructure by name", response = Infrastructure.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_INFRASTRUCTURE_BY_NAME, produces = "application/json")
	public ResponseEntity<List<Infrastructure>> findByName(@PathVariable String name) throws NotFoundException {
		return new ResponseEntity<List<Infrastructure>>(infrastructureService.findInfrastructureByName(name),
				HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "find infrastructure by id", response = Infrastructure.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_INFRASTRUCTURE_BY_ID,produces="application/json")
	public Infrastructure getInfrastructureById(@PathVariable("id") String id) throws NotFoundException{
		return infrastructureService.getInfrastructureById(id);
	}

	@ApiOperation(value = "Get faculty rooms", response = RoomAssociationData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_FACULTY_ROOMS, produces = "application/json")
	public List<RoomAssociationData> getRoomsAndAssociation() {
		return infrastructureService.getRooms();
	}

	@ApiOperation(value = "findIncharge", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_INCHARGES, method = RequestMethod.GET)
	public List<String> findInchargeOf(@RequestParam("id") String id) {
		return infrastructureService.findInchargeOf(id);
	}

	@ApiOperation(value = "getInfraInchargeDetails", response = Object.class, httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = RestAPI.GET_INFRA_INCHARGE_DETAILS, method = RequestMethod.GET)
	public List<InfrastructureInchargeResponse> getInfraInchargeDetails() {
		return infrastructureService.getInfraInchargeDetails();
	}

	@ApiOperation(value = "updateInfraInchargeDetails", response = Object.class, httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = RestAPI.UPDATE_INFRA_INCHARGE_DETAILS, method = RequestMethod.POST)
	public ResponseEntity<?> updateIncharge(@RequestBody UpdateInfraInchargeDetail details,
			HttpServletRequest request) {
		String id = jwtResolver.getIdFromJwtToken(request.getHeader("Authorization"));
		Infrastructure test = infrastructureService.updateIncharge(details, id);
		if (test != null)
			return new ResponseEntity<>(new ResponseMessage("Successfully updated."), HttpStatus.OK);
		else
			return new ResponseEntity<>(new ResponseMessage("Error occured. Try again later."), HttpStatus.BAD_REQUEST);
	}
}
