package sgsits.cse.dis.infrastructure.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import sgsits.cse.dis.infrastructure.constants.RestAPI;
import sgsits.cse.dis.infrastructure.exception.ConflictException;
import sgsits.cse.dis.infrastructure.feignClient.UserClient;
import sgsits.cse.dis.infrastructure.jwt.JwtResolver;
import sgsits.cse.dis.infrastructure.model.Infrastructure;
import sgsits.cse.dis.infrastructure.response.InfrastructureBrief;
import sgsits.cse.dis.infrastructure.response.ResponseMessage;
import sgsits.cse.dis.infrastructure.response.RoomAssociationData;
import sgsits.cse.dis.infrastructure.service.InfrastructureService;

/**
 * <h1>InfrastructureController</h1> class.
 * <p>This controller exposes infrastructure services as REST end points at default path <b>/infrastucture</b>.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 27-JAN-2020.
 * @throws ConflictException.
 * @throws NotFoundException.
 * @throws EventDoesNotExistException.
 * @throws DataIntegrityViolationException
 * @throws MethodArgumentNotValidException
 * @see NotFoundException.
 * @see DataIntegrityViolationException
 * @see MethodArgumentNotValidException
 */
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

	@ApiOperation(value = "Get Infrastructure type list", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_INFRASTRUCTURE_TYPE, produces = "application/json")
	public ResponseEntity<List<String>> getInfrastructureTypeList() {
		return new ResponseEntity<List<String>>(infrastructureService.getInfrastructureTypeList(), HttpStatus.OK);
	}

	@ApiOperation(value = "Get Infrastructure type list", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path = RestAPI.ADD_NEW_INFRASTRUCTURE_LOCATION, produces = "application/json")
	public ResponseEntity<ResponseMessage> addNewInfrastructureLocation(@PathVariable("location") String location)
			throws ConflictException {
		return new ResponseEntity<ResponseMessage>(
				new ResponseMessage(infrastructureService.addNewInfrastructureLocation(location)), HttpStatus.OK);
	}

	@ApiOperation(value = "Get staff name list", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_STAFF_NAME_LIST, produces = "application/json")
	public ResponseEntity<List<String>> getStaffData() {
		return new ResponseEntity<List<String>>(
				userClient.getStaffNameList().stream().map(faculty -> faculty.getName()).collect(Collectors.toList()),
				HttpStatus.OK);

	}

	@ApiOperation(value = "Get faculty name list", response = String.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_FACULTY_NAME_LIST, produces = "application/json")
	public ResponseEntity<List<String>> getFacultyData() {
		return new ResponseEntity<List<String>>(
				userClient.getFacultyNameList().stream().map(faculty -> faculty.getName()).collect(Collectors.toList()),
				HttpStatus.OK);
	}

	@ApiOperation(value="Get Infrastructure type list", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path=RestAPI.ADD_NEW_INFRASTRUCTURE, produces = "application/json")
	public ResponseEntity<ResponseMessage> addNewInfrastructure(@RequestBody @Valid Infrastructure infrastructure,HttpServletRequest request) throws ConflictException{
		return new ResponseEntity<ResponseMessage>( new ResponseMessage(infrastructureService.addNewInfrastructure(infrastructure,
									jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")))),HttpStatus.OK);
	}
	
	@ApiOperation(value="Delete Infrastructure", response = ResponseMessage.class, httpMethod = "DELETE", produces = "application/json")
	@DeleteMapping(path=RestAPI.DELETE_INFRASTRUCTURE, produces = "application/json")
	public ResponseEntity<ResponseMessage> deleteInfrastructure(@PathVariable("id") String id) throws ConflictException{
		infrastructureService.deleteInfrastructure(id);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Deleted sucessufully"),HttpStatus.OK);
	}
	
	@ApiOperation(value="Update Infrastructure", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path=RestAPI.UPDATE_INFRASTRUCTURE, produces = "application/json")
	public ResponseEntity<ResponseMessage> updateInfrastructure(@RequestBody Infrastructure infrastructure,HttpServletRequest request) throws ConflictException{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(infrastructureService.updateInfrastructure(infrastructure,
				jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")))),HttpStatus.OK);
	}
	
	@ApiOperation(value = "find Infrastructure by name", response = Infrastructure.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_INFRASTRUCTURE_BY_NAME,produces="application/json")
	public ResponseEntity<List<Infrastructure>> findByName(@PathVariable String name) throws NotFoundException {
		return new ResponseEntity<List<Infrastructure>>(infrastructureService.findInfrastructureByName(name),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get faculty rooms", response = RoomAssociationData.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(value = RestAPI.GET_FACULTY_ROOMS)
	public List<RoomAssociationData> getRoomsAndAssociation(){
		return infrastructureService.getRooms();
	}
}
