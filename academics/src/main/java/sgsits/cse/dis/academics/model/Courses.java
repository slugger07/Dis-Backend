package sgsits.cse.dis.academics.model;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private long id;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "created_date", nullable = false)
	private Instant createdDate;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_date")
	private Instant modifiedDate;

	@Column(name = "course_id", nullable = false, unique = true)
	private String courseId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "intake", nullable = false)
	private int intake;

	@Column(name = "increase_in_intake", nullable = false)
	private int increaseInIntake;

	@Column(name = "date_of_approval", nullable = false)
	private Date dateOfApproval;

	@Column(name = "approval_pdf")
	private String approvalPdf;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIntake() {
		return intake;
	}

	public void setIntake(int intake) {
		this.intake = intake;
	}

	public int getIncreaseInIntake() {
		return increaseInIntake;
	}

	public void setIncreaseInIntake(int increaseInIntake) {
		this.increaseInIntake = increaseInIntake;
	}

	public Date getDateOfApproval() {
		return dateOfApproval;
	}

	public void setDateOfApproval(Date dateOfApproval) {
		this.dateOfApproval = dateOfApproval;
	}

	public String getApprovalPdf() {
		return approvalPdf;
	}

	public void setApprovalPdf(String approvalPdf) {
		this.approvalPdf = approvalPdf;
	}	
}