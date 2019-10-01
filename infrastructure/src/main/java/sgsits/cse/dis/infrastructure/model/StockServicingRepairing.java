package sgsits.cse.dis.infrastructure.model;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_servicing_repairing_details")
public class StockServicingRepairing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private long id;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_date")
	private Instant createdDate;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "modified_date")
	private Instant modifiedDate;

	@Column(name = "service_id")
	private String serviceId;
	
	@Column(name = "stock_id")
	private String stockId;
	
	@Column(name = "date_of_request")
	private Date dateOfRequest;
	
	@Column(name = "date_of_completion")
	private Date dateOfCompletion;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "name_of_party")
	private String nameOfParty;
	
	@Column(name = "address_of_party")
	private String addressOfParty;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "bill_pdf")
	private String billPdf;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public Date getDateOfCompletion() {
		return dateOfCompletion;
	}

	public void setDateOfCompletion(Date dateOfCompletion) {
		this.dateOfCompletion = dateOfCompletion;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getNameOfParty() {
		return nameOfParty;
	}

	public void setNameOfParty(String nameOfParty) {
		this.nameOfParty = nameOfParty;
	}

	public String getAddressOfParty() {
		return addressOfParty;
	}

	public void setAddressOfParty(String addressOfParty) {
		this.addressOfParty = addressOfParty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBillPdf() {
		return billPdf;
	}

	public void setBillPdf(String billPdf) {
		this.billPdf = billPdf;
	}

}
