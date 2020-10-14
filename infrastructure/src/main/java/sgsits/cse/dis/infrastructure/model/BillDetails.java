package sgsits.cse.dis.infrastructure.model;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bill_details")
@Data
@NoArgsConstructor
public class BillDetails {
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
	
	@Column(name = "order_no")
	private String orderNo;
	
	@Column(name = "name_of_supplier")
	private String nameOfSupplier;
	
	@Column(name = "address_of_supplier")
	private String addressOfSupplier;
	
	@Column(name = "bill_no")
	private String billNo;
	
	@Column(name = "date_of_purchase")
	@Temporal(TemporalType.DATE)
	private Date dateOfPurchase;
	
	@Column(name = "item_name")
	private String itmeName;
	
	@Column(name = "specifications")
	private String specifications;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "cgst")
	private Double cgst;
	
	@Column(name = "sgst")
	private Double sgst;
	
	@Column(name = "total_price")
	private Double totalPrice;
	
	@Column(name = "warranty_period")
	private Integer warrantyPeriod ;
	
	@Column(name = "status")
	private String status;
}
