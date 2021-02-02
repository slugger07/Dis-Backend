package sgsits.cse.dis.infrastructure.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.infrastructure.exception.ConflictException;
import sgsits.cse.dis.infrastructure.model.BillDetails;
import sgsits.cse.dis.infrastructure.model.EquipmentDetails;
import sgsits.cse.dis.infrastructure.model.EquipmentType;
import sgsits.cse.dis.infrastructure.repo.BillDetailsRepository;
import sgsits.cse.dis.infrastructure.repo.EquipmentDetailsRepository;
import sgsits.cse.dis.infrastructure.repo.EquipmentTypeRepository;
import sgsits.cse.dis.infrastructure.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	
	@Autowired
	private EquipmentTypeRepository equipmentTypeRepository;
	
	@Autowired
	private EquipmentDetailsRepository equipmentDetailsRepository;
	
	@Autowired
	private BillDetailsRepository billDetailsRepository;
	
	@Override
	public void addEquipmentType(String type) throws ConflictException {
		if (equipmentTypeRepository.findByType(type).isPresent()) 
			throw new ConflictException("Entry with "+type+" already exists");
		EquipmentType temp = new EquipmentType();
		temp.setType(type);
		equipmentTypeRepository.save(temp);
	}

	@Override
	public List<EquipmentType> getEquipmentTypeList() {
		return equipmentTypeRepository.findAll();
	}

	@Override
	public String addEquipmentDetails(EquipmentDetails equipmentDetails, String addedBy) throws ConflictException {
		equipmentDetails.setCreatedDate(java.time.Clock.systemUTC().instant());
		equipmentDetails.setCreatedBy(addedBy);
		if(null == equipmentDetailsRepository.save(equipmentDetails))
			throw new ConflictException("Unable to add new equipment");
		
		return "Added successfully.";
	}

	@Transactional
	@Override
	public String deleteEquipmentDetailsWithId(String id) throws ConflictException {
		if(equipmentDetailsRepository.deleteEquipmentDetailById(id) <= 0)
				throw new ConflictException("Unable to delete equipment");
			return "Deleted Successfully";
	}
	
	@Override
	public List<EquipmentDetails> getAllEquipment() {
		return equipmentDetailsRepository.findAll();
	}

	@Override
	public List<EquipmentDetails> getEquipmentByType(String type) {
		return equipmentDetailsRepository.findByEquipmentType(type);
	}

	@Override
	public List<EquipmentDetails> getEquipmentByLab(String lab) {
		return equipmentDetailsRepository.findByRoomNameContaining(lab);
	}

	@Override
	public List<EquipmentDetails> getEquipmentByLabAndType(String lab, String type) {
		return equipmentDetailsRepository.findByRoomNameContainingAndEquipmentTypeContaining(lab, type);
	}

	@Override
	public String addStockBill(BillDetails billDetails, String addedBy) throws ConflictException {
		billDetails.setCreatedDate(java.time.Clock.systemUTC().instant());
		billDetails.setCreatedBy(addedBy);
		if(null == billDetailsRepository.save(billDetails))
			throw new ConflictException("Unable to add new equipment");
		
		return "Added successfully.";
	}

	@Transactional
	@Override
	public String deleteBillDetailsWithId(String id) throws ConflictException {
		if(billDetailsRepository.deleteStockBillById(id) <= 0)
			throw new ConflictException("Unable to delete equipment");
		return "Deleted Successfully";
	}

	@Override
	public List<BillDetails> getStockBill() {
		return billDetailsRepository.findAll();
	}

	@Override
	public List<BillDetails> getStockBillBySupplierName(String name) {
		return billDetailsRepository.findByNameOfSupplierContaining(name);
	}

	@Override
	public List<BillDetails> getStockBillByDateOfPurchase(Date date) {
		return billDetailsRepository.findByDateOfPurchase(date);
	}

	@Override
	public List<BillDetails> getStockBillByBetweenDateOfPurchase(Date date1, Date date2) {
		return billDetailsRepository.findByDateOfPurchaseBetween(date1, date2);
	}


}
