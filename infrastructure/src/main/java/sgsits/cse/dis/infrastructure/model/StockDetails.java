package sgsits.cse.dis.infrastructure.model;

import java.time.Instant;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>StockDetails</b> class.</h1>
 * <p>This class is model for table <b>stock_details</b> to act as DAO.
 * Details of all the stocks present in different infrastructure.
 * This table contains
 * @author Arjit Mishra,Devyani garg.
 * @version 1.0.
 * @since 25-JAN-2020.
 */
@Entity
@Table(name = "stock_details")
public class StockDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
	private String id;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_date")
	private Instant createdDate;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "modified_date")
	private Instant modifiedDate;

	@Column(name = "stock_id")
	private String stockId;
	
	@Column(name = "order_no")
	private String orderNo;
	
	@Column(name = "name_of_supplier")
	private String nameOfSupplier;
	
	@Column(name = "address_of_supplier")
	private String addressOfSupplier;
	
	@Column(name = "bill_no")
	private String billNo;
	
	@Column(name = "date_of_purchase")
	private Date dateOfPurchase;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "specifications")
	private String specifications;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "cgst")
	private double cgst;
	
	@Column(name = "sgst")
	private double sgst;
	
	//private In lieu of existing item;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Column(name = "warranty_period")
	private int warrantyPeriod;
	
	//private Grant Head;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "resource_id")
	private String resourceId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Instant getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Instant modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getNameOfSupplier() {
		return nameOfSupplier;
	}

	public void setNameOfSupplier(String nameOfSupplier) {
		this.nameOfSupplier = nameOfSupplier;
	}

	public String getAddressOfSupplier() {
		return addressOfSupplier;
	}

	public void setAddressOfSupplier(String addressOfSupplier) {
		this.addressOfSupplier = addressOfSupplier;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	
}