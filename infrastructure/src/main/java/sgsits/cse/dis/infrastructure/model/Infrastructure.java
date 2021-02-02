package sgsits.cse.dis.infrastructure.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>Infrastructure</b> class.</h1>
 * <p>This class is model for table <b>infrastructure</b> to act as DAO.
 * This table contains details of infrastructure in the department.
 * @author Arjit Mishra,Devyani Garg.
 * @version 1.0.
 * @since 25-JAN-2020.
 */
@Entity
@Table(name = "infrastructure")
public class Infrastructure {
   
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
	
	@NotBlank(message = "Name cannot be null/empty")
	@Column(name = "name")
	private String name;
	
	@Column(name = "name_acronym")
	private String nameAcronym;
	
	@NotBlank(message = "Type cannot be null/empty")
	@Column(name = "type")
	private String type;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "incharge")
	private String incharge;
	
	@Column(name = "associate_incharge")
	private String associateIncharge;
	
	@Column(name = "staff")
	private String staff;
	
	@Column(name = "attendant")
	private String attendant;
	
	@Column(name = "no_of_tables")
	private Integer noofTables;
	
	@Column(name = "no_of_computer_tables")
	private Integer noofComputerTables;
	
	@Column(name = "no_of_chairs")
	private Integer noofChairs;
	
	@Column(name = "no_of_almirah")
	private Integer noofAlmirah;
	
	@Column(name = "description")
	private String description;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameAcronym() {
		return nameAcronym;
	}

	public void setNameAcronym(String nameAcronym) {
		this.nameAcronym = nameAcronym;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIncharge() {
		return incharge;
	}

	public void setIncharge(String incharge) {
		this.incharge = incharge;
	}

	public String getAssociateIncharge() {
		return associateIncharge;
	}

	public void setAssociateIncharge(String associateIncharge) {
		this.associateIncharge = associateIncharge;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getAttendant() {
		return attendant;
	}

	public void setAttendant(String attendant) {
		this.attendant = attendant;
	}

	public Integer getNoofTables() {
		return noofTables;
	}
	
	
	public void setNoofTables(Integer noofTables) {
		this.noofTables = noofTables;
	}

	public Integer getNoofComputerTables() {
		return noofComputerTables;
	}

	public void setNoofComputerTables(Integer noofComputerTables) {
		this.noofComputerTables = noofComputerTables;
	}

	public Integer getNoofChairs() {
		return noofChairs;
	}

	public void setNoofChairs(Integer noofChairs) {
		this.noofChairs = noofChairs;
	}

	public Integer getNoofAlmirah() {
		return noofAlmirah;
	}

	public void setNoofAlmirah(Integer noofAlmirah) {
		this.noofAlmirah = noofAlmirah;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


		

}