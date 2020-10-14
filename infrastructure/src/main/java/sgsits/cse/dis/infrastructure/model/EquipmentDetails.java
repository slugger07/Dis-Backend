package sgsits.cse.dis.infrastructure.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipment_details")
@Data
@NoArgsConstructor
public class EquipmentDetails {
   
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
	
	@Column(name = "equipment_type")
	private String equipmentType;
	
	@Column(name = "bill_no")
	private String billNo;
	
	@Column(name = "equipment_name")
	private String equipmentName;
	
	@Column(name = "no_of_equipment")
	private Integer noOfEquipment;
	
	@Column(name = "room_name")
	private String roomName;
	
}
