package sgsits.cse.dis.user.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "first_year_be_student")
public class FirstYearBeStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    private String createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private String modifiedDate;

    @Column(name = "enrollment_id", nullable = false, unique = true)
    private String enrollmentId;

    @Column(name = "roll_no")
    private String rollNo;

    @Column(name = "branch")
    private String branch;

    @Column(name = "section")
    private String section;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "mobile_no")
    private Long mobileNo;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "admission_date")
    private int admissionDate;

    @Column(name = "admission_year")
    private int admissionYear;

    @Column(name = "address")
    private String address;

    @Column(name = "district")
    private String district;

    @Column(name = "religion")
    private String religion;

    @Column(name = "email")
    private String email;

    @Column(name = "category")
    private String category;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(final String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(final String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(final String rollNo) {
        this.rollNo = rollNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(final String branch) {
        this.branch = branch;
    }

    public String getSection() {
        return section;
    }

    public void setSection(final String section) {
        this.section = section;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(final String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(final String motherName) {
        this.motherName = motherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(final Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(final Date dob) {
        this.dob = dob;
    }

    public int getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(final int admissionDate) {
        this.admissionDate = admissionDate;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(final int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(final String district) {
        this.district = district;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(final String religion) {
        this.religion = religion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }
}
