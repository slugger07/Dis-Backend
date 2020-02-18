package sgsits.cse.dis.user.message.request;

import java.sql.Date;


/**
 * <h1>AddNewUser</h1>class.
 * This class is pojo form for converting json and mapping into this java object
 * @author Arjit Mishra
 * @since 27-JAN-2020
 */

public class AddNewUser {
	private String employeeId;
	private String name;
	private String currentDesignation;
	private String classs;
	private String type;
	private String joiningDate;
	private String email;
	private Date dob;
	private Long mobileNo;
	
	
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
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
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
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
