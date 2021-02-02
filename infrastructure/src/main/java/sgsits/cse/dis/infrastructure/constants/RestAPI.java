package sgsits.cse.dis.infrastructure.constants;

public class RestAPI {

	public static final String GET_LIST_OF_INFRASTRUCTURE_LOCATIONS = "/getListOfInfrastructureLocations";
	public static final String GET_ALL_INFRASTRUCTURE = "/getAllInfrastructure";
	public static final String GET_INFRASTRUCTURE_BY_TYPE = "/getInfrastructureByType/{type}";
	public static final String GET_INFRASTRUCTURE_TYPE = "/getInfrastructureTypeList";
	public static final String ADD_NEW_INFRASTRUCTURE_LOCATION = "/addNewInfrastructureLocation/{location}";
	public static final String GET_ACTIVE_STAFF_LIST = "/getActiveStaffList";
	public static final String ADD_NEW_INFRASTRUCTURE = "/addNewInfrastructure";
	public static final String DELETE_INFRASTRUCTURE = "/deleteInfrastructure/{id}";
	public static final String UPDATE_INFRASTRUCTURE = "/updateInfrastructure";
	public static final String GET_STAFF_NAME_LIST = "/getStaffNameList";
	public static final String GET_FACULTY_NAME_LIST = "/getFacultyNameList";
	public static final String GET_INFRASTRUCTURE_BY_NAME = "/findInfrastructure/{name}";
	public static final String GET_FACULTY_ROOMS = "/getRooms";
	public static final String GET_INFRASTRUCTURE_BY_ID = "/getInfrastructurebyId/{id}";

	public static final String ADD_NEW_EQUIPMENT_TYPE = "/addNewEquipmentType/{type}";
	public static final String GET_EQUIPMENT_TYPE_LIST = "/getEquipmentTypeList";
	public static final String ADD_EQUIPMENT_DETAIL = "/addEquipmentDetail";
	public static final String DELETE_EQUIPMENT_DETAIL = "/deleteEquipmentDetail/{id}";
	public static final String GET_ALL_EQUIPMENTS = "/getAllEquipments";
	public static final String GET_EQUIPMENTS_BY_TYPE = "/getEquipmentsByType/{type}";
	public static final String GET_EQUIPMENTS_BY_LAB = "/getEquipmentsByLab/{lab}";
	public static final String GET_EQUIPMENTS_BY_LAB_AND_TYPE = "/getEquipmentsByLab/{lab}/{type}";

	public static final String ADD_STOCK_BILL = "/addStockBill";
	public static final String DELETE_BILL_DETAIL = "/deleteBillDetail/{id}";
	public static final String GET_STOCK_BILLS = "/getStockBills";
	public static final String GET_STOCK_BILLS_BY_SUPPLIER_NAME = "/getStockBillsBySupplierName/{name}";
	public static final String GET_STOCK_BILLS_BY_DATE_OF_PURCHASE = "/getStockBillsByDate/{dateOfPurchase}";
	public static final String GET_STOCK_BILLS_BETWEEN_DATE_OF_PURCHASE = "/getStockBillsByDate/{dateOfPurchaseStart}/{dateOfPurchaseEnd}";

	public static final String GET_INCHARGES = "/findIncharge";
	public static final String GET_INFRA_INCHARGE_DETAILS = "/getInfraInchargeDetails";
	public static final String UPDATE_INFRA_INCHARGE_DETAILS = "/updateInfraInchargeDetails";


}
