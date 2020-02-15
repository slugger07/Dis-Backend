package sgsits.cse.dis.user.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>StaffBasicProfile</b> class.</h1>
 * <p>This class is model for table <b>staff_basic_profile</b> to act as DAO.
 * This table contains basic profile for newly added member in the DIS and now can successfully signup on the system.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 4-JAN-2020.
 */
@Entity
@Table(name = "staff_basic_profile")
public class StaffProfile {
	
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true)
    private String id;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_date")
	private String modifiedDate;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "employee_id", unique = true)
	private String employeeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "name_acronym",unique = true)
	private String nameAcronym;
	
	@Column(name = "current_designation")
	private String currentDesignation;
	
	@Column(name = "class")
	private String classs;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "pan_number")
	private String panNumber;
	
	@Column(name = "aadhar_number")
	private String aadharNumber;
	
	@Column(name = "blood_group")
	private String bloodGroup;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "mother_name")
	private String motherName;
	
	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "mobile_no")
	private Long mobileNo;
	
	@Column(name = "alternate_mobile_no")
	private Long alternateMobileNo;
	
	@Column(name = "joining_date")
	private String joiningDate;
	
	@Column(name = "area_of_specialization")
	private String areaOfSpecialization;
	
	

	public StaffProfile() {
		super();
	}



	public StaffProfile(String createdBy, String createdDate,String employeeId,String name, String currentDesignation, String classs,
			String type, String email, String dob, Long mobileNo, String joiningDate) {
		super();
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.employeeId = employeeId;
		this.name = name;
		this.currentDesignation = currentDesignation;
		this.classs = classs;
		this.type = type;
		this.email = email;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.joiningDate = joiningDate;
	}


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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public String getCurrentDesignation() {
		return currentDesignation;
	}

	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getAlternateMobileNo() {
		return alternateMobileNo;
	}

	public void setAlternateMobileNo(long alternateMobileNo) {
		this.alternateMobileNo = alternateMobileNo;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getAreaOfSpecialization() {
		return areaOfSpecialization;
	}

	public void setAreaOfSpecialization(String areaOfSpecialization) {
		this.areaOfSpecialization = areaOfSpecialization;
	}
}
