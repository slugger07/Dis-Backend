package sgsits.cse.dis.infrastructure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

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
	private String createdDate;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "modified_date")
	private String modifiedDate;
	
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
	
	@Column(name = "incharge_name")
	private String inchargeName; 
	
	
	public String getInchargeName() {
		return inchargeName;
	}

	public void setInchargeName(String inchargeName) {
		this.inchargeName = inchargeName;
	}

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


	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String string) {
		this.modifiedDate = string;
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