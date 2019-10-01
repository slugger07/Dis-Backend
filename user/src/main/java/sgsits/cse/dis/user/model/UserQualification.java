package sgsits.cse.dis.user.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_qualification")
public class UserQualification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "modified_by")
	private Long modifiedBy;

	@Column(name = "modified_date")
	private Date modifiedDate;

	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "degree_certificate")
	private String degreeCertificate;
	
	@Column(name = "year_of_passing")
	private int yearOfPassing;
	
	@Column(name = "college_school")
	private String collegeSchool;
	
	@Column(name = "university_board")
	private String universityBoard;
	
	@Column(name = "percentage_cgpa")
	private String percentageCgpa;
	
	@Column(name = "specialization")
	private String specialization;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDegreeCertificate() {
		return degreeCertificate;
	}

	public void setDegreeCertificate(String degreeCertificate) {
		this.degreeCertificate = degreeCertificate;
	}

	public int getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(int yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public String getCollegeSchool() {
		return collegeSchool;
	}

	public void setCollegeSchool(String collegeSchool) {
		this.collegeSchool = collegeSchool;
	}

	public String getUniversityBoard() {
		return universityBoard;
	}

	public void setUniversityBoard(String universityBoard) {
		this.universityBoard = universityBoard;
	}

	public String getPercentageCgpa() {
		return percentageCgpa;
	}

	public void setPercentageCgpa(String percentageCgpa) {
		this.percentageCgpa = percentageCgpa;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
}
