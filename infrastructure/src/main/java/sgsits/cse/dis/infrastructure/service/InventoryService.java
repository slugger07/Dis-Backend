package sgsits.cse.dis.infrastructure.service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import sgsits.cse.dis.infrastructure.exception.ConflictException;
import sgsits.cse.dis.infrastructure.model.BillDetails;
import sgsits.cse.dis.infrastructure.model.EquipmentDetails;
import sgsits.cse.dis.infrastructure.model.EquipmentType;

/**
 * <h1><b>InventoryService</b> interface.</h1>
 * <p>This interface lists all the Inventory services which can be implemented by class extending it.
 * 
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 07-OCT-2020.
 * @throws ConflictException.
 * @throws NotFoundException.
 * @throws EventDoesNotExistException.
 * @throws DataIntegrityViolationException
 * @throws MethodArgumentNotValidException
 * @see NotFoundException.
 * @see DataIntegrityViolationException
 * @see MethodArgumentNotValidException
 */

public interface InventoryService {
	public void addEquipmentType(String type) throws ConflictException;
	public List<EquipmentType> getEquipmentTypeList();
	public String addEquipmentDetails(EquipmentDetails equipmentDetails, String addedBy) throws ConflictException;
	public String deleteEquipmentDetailsWithId(String id) throws ConflictException;
	public List<EquipmentDetails> getEquipmentByType(String type);
	public List<EquipmentDetails> getAllEquipment();
	public List<EquipmentDetails> getEquipmentByLab(String lab);
	public List<EquipmentDetails> getEquipmentByLabAndType(String lab, String type);
	
	public String addStockBill(BillDetails billDetails, String addedBy) throws ConflictException;
	public String deleteBillDetailsWithId(String id) throws ConflictException;
	public List<BillDetails> getStockBill();
	public List<BillDetails> getStockBillBySupplierName(String name);
	public List<BillDetails> getStockBillByDateOfPurchase(Date date);
	public List<BillDetails> getStockBillByBetweenDateOfPurchase(Date date1, Date date2);
	
}
