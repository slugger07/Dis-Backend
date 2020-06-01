package sgsits.cse.dis.user.dtos;

import java.util.Date;

public class StaffBasicProfileDto {

    private String id;
    private String userId;
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

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getNameAcronym() {
        return nameAcronym;
    }

    public void setNameAcronym(final String nameAcronym) {
        this.nameAcronym = nameAcronym;
    }

    public String getCurrentDesignation() {
        return currentDesignation;
    }

    public void setCurrentDesignation(final String currentDesignation) {
        this.currentDesignation = currentDesignation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(final Date dob) {
        this.dob = dob;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(final String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(final String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(final String fatherName) {
        this.fatherName = fatherName;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(final long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getAlternateMobileNo() {
        return alternateMobileNo;
    }

    public void setAlternateMobileNo(final Long alternateMobileNo) {
        this.alternateMobileNo = alternateMobileNo;
    }

    public String getAreaOfSpecialization() {
        return areaOfSpecialization;
    }

    public void setAreaOfSpecialization(final String areaOfSpecialization) {
        this.areaOfSpecialization = areaOfSpecialization;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(final String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(final String presentAddress) {
        this.presentAddress = presentAddress;
    }
}
