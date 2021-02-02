package sgsits.cse.dis.academics.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>SemTimeTable</b> class.</h1>
 * <p>This class is model for table <b>sem_time_table</b> to act as DAO.
 * This table contains time table settings.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 26-FEB-2020.
 */

@Entity
@Table(name = "sem_time_table")
public class SemTimeTable {

		@Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(
	            name="UUID",
	            strategy="org.hibernate.id.UUIDGenerator"
	    )
		private String id;
		
		@Column(name = "created_by")
		private String createdBy;
		
		@Column(name = "created_date")
		private Instant createdDate;
		
		@Column(name = "subject_code")
		private String subjectCode;
		
		@Column(name = "lecture_type")
		private String lectureType;
		
		@Column(name = "session")
		private String session;
		
		@Column(name = "year")
		private String year;
		
		@Column(name = "semester")
		private String semester;
		
		@Column(name = "course_id")
		private String courseId;

		public SemTimeTable() {
			super();
			// TODO Auto-generated constructor stub
		}


		public SemTimeTable(String createdBy, Instant createdDate, String subjectCode, String lectureType,
				String session, String year, String semester, String courseId) {
			super();
			this.createdBy = createdBy;
			this.createdDate = createdDate;
			this.subjectCode = subjectCode;
			this.lectureType = lectureType;
			this.session = session;
			this.year = year;
			this.semester = semester;
			this.courseId = courseId;
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

		public String getSubjectCode() {
			return subjectCode;
		}

		public void setSubjectCode(String subjectCode) {
			this.subjectCode = subjectCode;
		}

		public String getLectureType() {
			return lectureType;
		}

		public void setLectureType(String lectureType) {
			this.lectureType = lectureType;
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
		
}
