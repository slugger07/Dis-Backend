package sgsits.cse.dis.academics.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>Scheme</b> class.</h1>
 * <p>This class is model for table <b>scheme</b> to act as DAO.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-DEC-2019.
 */
@Entity
@Table(name = "scheme")
public class Scheme {
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
	private String id;
	
	@Column(name = "created_by", nullable = false)
	private String createdBy;
	
	@Column(name = "created_date", nullable = false)
	private Instant createdDate;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "modified_date")
	private Instant modifiedDate;
	
	//@ManyToOne
	//@JoinColumn(name = "course_id", nullable = false)
	//private Courses courseId;
	
	@Column(name = "course_id", nullable = false)
	private String courseId;

	@Column(name = "session", nullable = false)
	private String session;
	
	@Column(name = "year", nullable = false)
	private String year;
	
	@Column(name = "semester", nullable = false)
	private String semester;
	
	@Column(name = "subject_code", nullable = false, unique = true)
	private String subjectCode;
	
	@Column(name = "subject_name", nullable = false, unique = true)
	private String subjectName;
	
	@Column(name = "subject_acronym", nullable = false, unique = true)
	private String subjectAcronym;
	
	@Column(name = "no_of_lecture_periods", nullable = false)
	private int noOfLecturePeriods;
	
	@Column(name = "no_of_tutorial_periods", nullable = false)
	private int noOfTutorialPeriods;
	
	@Column(name = "no_of_practical_periods", nullable = false)
	private int noOfPracticalPeriods;
	
	@Column(name = "no_of_theory_credits", nullable = false)
	private int noOfTheoryCredits;
	
	@Column(name = "no_of_practical_credits", nullable = false)
	private int noOfPracticalCredits;
	
	@Column(name = "no_of_credits_total", nullable = false)
	private int noOfCreditsTotal;
	
	@Column(name = "max_theory_marks", nullable = false)
	private int maxTheoryMarks;
	
	@Column(name = "max_cw", nullable = false)
	private int maxCw;
	
	@Column(name = "max_practical_marks", nullable = false)
	private int maxPracticalMarks;
	
	@Column(name = "max_sw", nullable = false)
	private int maxSw;
	
	@Column(name = "max_total", nullable = false)
	private int maxTotal;
	
	@Column(name = "syllabus_pdf", nullable = false)
	private String syllabusPdf;
	
	//@ManyToOne
	//@JoinColumn(name = "pdf_id")	
	//private Downloads pdfId;
	
	//@OneToMany(mappedBy = "subjectCode", cascade = CascadeType.ALL)
	//private List<Syllabus> syllabus;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getSyllabusPdf() {
		return syllabusPdf;
	}

	public void setPdfId(String syllabusPdf) {
		this.syllabusPdf = syllabusPdf;
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

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectAcronym() {
		return subjectAcronym;
	}

	public void setSubjectAcronym(String subjectAcronym) {
		this.subjectAcronym = subjectAcronym;
	}

	public int getNoOfLecturePeriods() {
		return noOfLecturePeriods;
	}

	public void setNoOfLecturePeriods(int noOfLecturePeriods) {
		this.noOfLecturePeriods = noOfLecturePeriods;
	}

	public int getNoOfTutorialPeriods() {
		return noOfTutorialPeriods;
	}

	public void setNoOfTutorialPeriods(int noOfTutorialPeriods) {
		this.noOfTutorialPeriods = noOfTutorialPeriods;
	}

	public int getNoOfPracticalPeriods() {
		return noOfPracticalPeriods;
	}

	public void setNoOfPracticalPeriods(int noOfPracticalPeriods) {
		this.noOfPracticalPeriods = noOfPracticalPeriods;
	}

	public int getNoOfTheoryCredits() {
		return noOfTheoryCredits;
	}

	public void setNoOfTheoryCredits(int noOfTheoryCredits) {
		this.noOfTheoryCredits = noOfTheoryCredits;
	}

	public int getNoOfPracticalCredits() {
		return noOfPracticalCredits;
	}

	public void setNoOfPracticalCredits(int noOfPracticalCredits) {
		this.noOfPracticalCredits = noOfPracticalCredits;
	}

	public int getNoOfCreditsTotal() {
		return noOfCreditsTotal;
	}

	public void setNoOfCreditsTotal(int noOfCreditsTotal) {
		this.noOfCreditsTotal = noOfCreditsTotal;
	}

	public int getMaxTheoryMarks() {
		return maxTheoryMarks;
	}

	public void setMaxTheoryMarks(int maxTheoryMarks) {
		this.maxTheoryMarks = maxTheoryMarks;
	}

	public int getMaxCw() {
		return maxCw;
	}

	public void setMaxCw(int maxCw) {
		this.maxCw = maxCw;
	}

	public int getMaxPracticalMarks() {
		return maxPracticalMarks;
	}

	public void setMaxPracticalMarks(int maxPracticalMarks) {
		this.maxPracticalMarks = maxPracticalMarks;
	}

	public int getMaxSw() {
		return maxSw;
	}

	public void setMaxSw(int maxSw) {
		this.maxSw = maxSw;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}
}
