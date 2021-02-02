package sgsits.cse.dis.user.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_attendance")
public class StudentAttendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private long id;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_date")
	private Date modifiedDate;

	@Column(name = "session")
	private String session;

	@Column(name = "enrollment_id", nullable = false)
	private String enrollmentId;

	@Column(name = "subject_code", nullable = false)
	private String subjectCode;
	
	@Column(name = "class_type", nullable = false)
	private char classType;
	
	@Column(name = "class_date", nullable = false)
	private Date classDate;
	
	@Column(name = "from_time", nullable = false)
	private Time from;
	
	@Column(name = "to_time", nullable = false)
	private Time to;
	
	@Column(name = "attendance", nullable = false)
	private Byte attendance;

	@Column(name = "lecture_count", nullable = false)
	private Byte lectureCount;

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public char getClassType() {
		return classType;
	}

	public void setClassType(char classType) {
		this.classType = classType;
	}

	public Date getClassDate() {
		return classDate;
	}

	public void setClassDate(Date classDate) {
		this.classDate = classDate;
	}

	public Time getFrom() {
		return from;
	}

	public void setFrom(Time from) {
		this.from = from;
	}

	public Time getTo() {
		return to;
	}

	public void setTo(Time to) {
		this.to = to;
	}

	public String getSession() {
		return session;
	}

	public void setSession(final String session) {
		this.session = session;
	}

	public Byte getAttendance() {
		return attendance;
	}

	public void setAttendance(final Byte attendance) {
		this.attendance = attendance;
	}

	public Byte getLectureCount() {
		return lectureCount;
	}

	public void setLectureCount(final Byte lectureCount) {
		this.lectureCount = lectureCount;
	}
}