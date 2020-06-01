package sgsits.cse.dis.user.dtos;

import java.sql.Date;

public class StudentBasicProfileDto {

    private String id;
    private String userId;
    private String enrollmentId;
    private String profilePicture;
    private String fullName;
    private int admissionYear;
    private String courseId;
    private Long mobileNo;
    private String email;
    private Date dob;
    private String fatherName;
    private Long fatherContact;
    private String fatherEmail;
    private String motherName;
    private Long motherContact;
    private String motherEmail;
    private String category;
    private String gender;
    private String bloodGroup;

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(final String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(final int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(final String courseId) {
        this.courseId = courseId;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(final Long mobileNo) {
        this.mobileNo = mobileNo;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(final String fatherName) {
        this.fatherName = fatherName;
    }

    public Long getFatherContact() {
        return fatherContact;
    }

    public void setFatherContact(final Long fatherContact) {
        this.fatherContact = fatherContact;
    }

    public String getFatherEmail() {
        return fatherEmail;
    }

    public void setFatherEmail(final String fatherEmail) {
        this.fatherEmail = fatherEmail;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(final String motherName) {
        this.motherName = motherName;
    }

    public Long getMotherContact() {
        return motherContact;
    }

    public void setMotherContact(final Long motherContact) {
        this.motherContact = motherContact;
    }

    public String getMotherEmail() {
        return motherEmail;
    }

    public void setMotherEmail(final String motherEmail) {
        this.motherEmail = motherEmail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(final String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
