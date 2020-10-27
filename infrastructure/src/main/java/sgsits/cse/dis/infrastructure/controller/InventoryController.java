package sgsits.cse.dis.infrastructure.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sgsits.cse.dis.infrastructure.constants.RestAPI;
import sgsits.cse.dis.infrastructure.exception.ConflictException;
import sgsits.cse.dis.infrastructure.jwt.JwtResolver;
import sgsits.cse.dis.infrastructure.model.BillDetails;
import sgsits.cse.dis.infrastructure.model.EquipmentDetails;
import sgsits.cse.dis.infrastructure.model.EquipmentType;
import sgsits.cse.dis.infrastructure.response.ResponseMessage;
import sgsits.cse.dis.infrastructure.service.InventoryService;
/**
 * <h1>InventoryController</h1> class.
 * <p>This controller exposes inventory services as REST end points at default path <b>/inventory</b>.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 04-OCT-2020.
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
@Api(value = "Inventory controller")
@RestController
@RequestMapping(path = "/inventory")
public class InventoryController {
	
	private JwtResolver jwtResolver = new JwtResolver();

	@Autowired
	private InventoryService inventoryService;
	
	
	@ApiOperation(value = "Add new equipment type", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path = RestAPI.ADD_NEW_EQUIPMENT_TYPE, produces = "application/json")
	public ResponseEntity<ResponseMessage> addNewEquipmentType(@PathVariable("type") String type) throws ConflictException{
		inventoryService.addEquipmentType(type);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Added successfully"), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get list of equipment type", response = EquipmentType.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_EQUIPMENT_TYPE_LIST, produces = "application/json")
	public ResponseEntity<List<EquipmentType>> getEquipmentTypeList() throws ConflictException{
		return new ResponseEntity<List<EquipmentType>>(inventoryService.getEquipmentTypeList(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add equipment detail", response = String.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path = RestAPI.ADD_EQUIPMENT_DETAIL, produces = "application/json")
	public ResponseEntity<ResponseMessage> addNewEquipmentType(@RequestBody EquipmentDetails equipmentDetails, HttpServletRequest request) throws ConflictException{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(inventoryService.addEquipmentDetails(equipmentDetails, 
				jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")))), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete equipment detail", response = String.class, httpMethod = "DELETE", produces = "application/json")
	@DeleteMapping(path = RestAPI.DELETE_EQUIPMENT_DETAIL, produces = "application/json")
	public ResponseEntity<ResponseMessage> deleteEquipmentDetail(@PathVariable("id") String id) throws ConflictException{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(inventoryService.deleteEquipmentDetailsWithId(id)), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all equipment", response = EquipmentDetails.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_ALL_EQUIPMENTS, produces = "application/json")
	public ResponseEntity<List<EquipmentDetails>> getAllEquipments() throws ConflictException{
		return new ResponseEntity<List<EquipmentDetails>>(inventoryService.getAllEquipment(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get equipment by type", response = EquipmentDetails.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_EQUIPMENTS_BY_TYPE, produces = "application/json")
	public ResponseEntity<List<EquipmentDetails>> getEquipmentsByType(@PathVariable("type") String type) throws ConflictException{
		return new ResponseEntity<List<EquipmentDetails>>(inventoryService.getEquipmentByType(type), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get equipment by lab", response = EquipmentDetails.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_EQUIPMENTS_BY_LAB, produces = "application/json")
	public ResponseEntity<List<EquipmentDetails>> getEquipmentsByLab(@PathVariable("lab") String lab) throws ConflictException{
		return new ResponseEntity<List<EquipmentDetails>>(inventoryService.getEquipmentByLab(lab), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Get equipment by lab and type", response = EquipmentDetails.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_EQUIPMENTS_BY_LAB_AND_TYPE, produces = "application/json")
	public ResponseEntity<List<EquipmentDetails>> getEquipmentsByLabAndType(@PathVariable("lab") String lab, @PathVariable("type") String type) throws ConflictException{
		return new ResponseEntity<List<EquipmentDetails>>(inventoryService.getEquipmentByLab(lab), HttpStatus.OK);
	}
	

	@ApiOperation(value = "Add stock bill", response = String.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path = RestAPI.ADD_STOCK_BILL, produces = "application/json")
	public ResponseEntity<ResponseMessage> addNewStockBill(@RequestBody BillDetails billDetails, HttpServletRequest request) throws ConflictException{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(inventoryService.addStockBill(billDetails, 
				jwtResolver.getIdFromJwtToken(request.getHeader("Authorization")))), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete bill details", response = String.class, httpMethod = "DELETE", produces = "application/json")
	@DeleteMapping(path = RestAPI.DELETE_BILL_DETAIL, produces = "application/json")
	public ResponseEntity<ResponseMessage> deleteBillDetail(@PathVariable("id") String id) throws ConflictException{
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(inventoryService.deleteBillDetailsWithId(id)), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get stock bills", response = BillDetails.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_STOCK_BILLS, produces = "application/json")
	public ResponseEntity<List<BillDetails>> getStockBills() throws ConflictException{
		return new ResponseEntity<List<BillDetails>>(inventoryService.getStockBill(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get stock bills by supplier's name", response = BillDetails.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_STOCK_BILLS_BY_SUPPLIER_NAME, produces = "application/json")
	public ResponseEntity<List<BillDetails>> getStockBillsBySupplierName(@PathVariable("name") String name) throws ConflictException{
		return new ResponseEntity<List<BillDetails>>(inventoryService.getStockBillBySupplierName(name), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get stock bills by date of purchase", response = BillDetails.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_STOCK_BILLS_BY_DATE_OF_PURCHASE, produces = "application/json")
	public ResponseEntity<List<BillDetails>> getStockBillsByDateOfPurchase(@PathVariable("dateOfPurchase") String dateOfPurchase) throws ConflictException, ParseException{
		Date date = new SimpleDateFormat("yy-MM-dd").parse(dateOfPurchase);
		return new ResponseEntity<List<BillDetails>>(inventoryService.getStockBillByDateOfPurchase(date), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get stock bills between date of purchases", response = BillDetails.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path = RestAPI.GET_STOCK_BILLS_BETWEEN_DATE_OF_PURCHASE, produces = "application/json")
	public ResponseEntity<List<BillDetails>> getStockBillsBetweenDateOfPurchase(@PathVariable("dateOfPurchaseStart") String dateOfPurchaseStart,@PathVariable("dateOfPurchaseEnd") String dateOfPurchaseEnd) throws ConflictException, ParseException{
		Date date1 = new SimpleDateFormat("yy-MM-dd").parse(dateOfPurchaseStart);
		Date date2 = new SimpleDateFormat("yy-MM-dd").parse(dateOfPurchaseEnd);
		return new ResponseEntity<List<BillDetails>>(inventoryService.getStockBillByBetweenDateOfPurchase(date1, date2), HttpStatus.OK);
	}
	
}
