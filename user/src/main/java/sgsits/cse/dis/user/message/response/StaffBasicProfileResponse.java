package sgsits.cse.dis.user.message.response;
/**
 * <h1>StaffBasicProfile</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Devyani garg
 * @since 8-DEC-2018
 */
import java.util.Date;

public class StaffBasicProfileResponse {
	
	private String employeeId;
	private String name;
	private String nameAcronym;
	private String currentDesignation;
	private String email;
	private Date dob;
	private String bloodGroup;
	private String gender;
	private String motherName;
	private String fatherName;
	private long mobileNo;
	private Long alternateMobileNo;
	private String areaOfSpecialization;
	private String permanentAddress;
	private String presentAddress;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getAlternateMobileNo() {
		return alternateMobileNo;
	}
	public void setAlternateMobileNo(long alternateMobileNo) {
		this.alternateMobileNo = alternateMobileNo;
	}
	public String getAreaOfSpecialization() {
		return areaOfSpecialization;
	}
	public void setAreaOfSpecialization(String areaOfSpecialization) {
		this.areaOfSpecialization = areaOfSpecialization;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
}
