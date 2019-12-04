package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library_thesis_records")

public class LibraryThesisRecords {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "thesis_id", nullable = false, unique = true)
	private long thesisId;
	
	@Column(name = "year")
	public String year;
	
	@Column(name = "submitted_by")
	public String submittedBy;
	
	@Column(name = "guided_by")
	public String guidedBy;

	@Column(name = "cd_status")
	public String cdStatus;
	
	@Column(name = "course", nullable = false)
	public String course;
	
	@Column(name = "entry_date", nullable = false)
	private String entryDate;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "status")
	private String status="Availabe";
	
	@Column(name = "remarks")
	private String remarks;

	public long getThesisId() {
		return thesisId;
	}

	public void setThesisId(long thesisId) {
		this.thesisId = thesisId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSubmittedby() {
		return submittedBy;
	}

	public void setSubmittedby(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getGuidedBy() {
		return guidedBy;
	}

	public void setGuidedBy(String guidedBy) {
		this.guidedBy = guidedBy;
	}

	public String getCdStatus() {
		return cdStatus;
	}

	public void setCdStatus(String cdStatus) {
		this.cdStatus = cdStatus;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
