package sgsits.cse.dis.academics.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "syllabus")
public class Syllabus {
	
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
	
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private Courses courseId;
	
	@Column(name = "session", nullable = false)
	private String session;
	
	@ManyToOne
	@JoinColumn(name = "subject_code", nullable = false)
	private Scheme subjectCode;
	
	@Column(name = "course_objectives")
	private String courseObjectives;
	
	@Column(name = "content_of_syllabus", nullable = false)
	private String contentOfSyllabus;
	
	@Column(name = "textbooks", nullable = false)
	private String textBooks;
	
	@Column(name = "reference_books", nullable = false)
	private String referenceBooks;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "research_paper")
	private String researchPaper;
	
	@Column(name = "course_outcome")
	private String courseOutcome;
	
	//@ManyToOne
	//@JoinColumn(name = "pdf_id", nullable = false)
	private String pdfId;

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

	public Courses getCourseId() {
		return courseId;
	}

	public void setCourseId(Courses courseId) {
		this.courseId = courseId;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public Scheme getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(Scheme subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getCourseObjectives() {
		return courseObjectives;
	}

	public void setCourseObjectives(String courseObjectives) {
		this.courseObjectives = courseObjectives;
	}

	public String getContentOfSyllabus() {
		return contentOfSyllabus;
	}

	public void setContentOfSyllabus(String contentOfSyllabus) {
		this.contentOfSyllabus = contentOfSyllabus;
	}

	public String getTextBooks() {
		return textBooks;
	}

	public void setTextBooks(String textBooks) {
		this.textBooks = textBooks;
	}

	public String getReferenceBooks() {
		return referenceBooks;
	}

	public void setReferenceBooks(String referenceBooks) {
		this.referenceBooks = referenceBooks;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getResearchPaper() {
		return researchPaper;
	}

	public void setResearchPaper(String researchPaper) {
		this.researchPaper = researchPaper;
	}

	public String getCourseOutcome() {
		return courseOutcome;
	}

	public void setCourseOutcome(String courseOutcome) {
		this.courseOutcome = courseOutcome;
	}

	public String getPdfId() {
		return pdfId;
	}

	public void setPdfId(String pdfId) {
		this.pdfId = pdfId;
	}
}