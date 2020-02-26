package sgsits.cse.dis.academics.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>SemTimeTableSettings</b> class.</h1>
 * <p>This class is model for table <b>sem_time_table_settings</b> to act as DAO.
 * This table contains time table settings.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 25-FEB-2020.
 */
@Entity
@Table(name = "sem_time_table_settings")
public class SemTimeTableSettings {
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
	private String id;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "modified_date")
	private Instant modifiedDate;
	
	@Column(name = "lecture_length")
	private Integer lectureLength;
	
	@Column(name = "lunch_start_time")
	private String lunchStartTime;
	

	@Column(name = "lunch_end_time")
	private String lunchEndTime;


	/**
	 * @return
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}


	/**
	 * @param modifiedBy
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	/**
	 * @return
	 */
	public Instant getModifiedDate() {
		return modifiedDate;
	}


	/**
	 * @param modifiedDate
	 */
	public void setModifiedDate(Instant modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	/**
	 * @return
	 */
	public Integer getLectureLength() {
		return lectureLength;
	}


	/**
	 * @param lectureLength
	 */
	public void setLectureLength(Integer lectureLength) {
		this.lectureLength = lectureLength;
	}


	/**
	 * @return
	 */
	public String getLunchStartTime() {
		return lunchStartTime;
	}


	/**
	 * @param lunchStartTime
	 */
	public void setLunchStartTime(String lunchStartTime) {
		this.lunchStartTime = lunchStartTime;
	}


	/**
	 * @return
	 */
	public String getLunchEndTime() {
		return lunchEndTime;
	}


	/**
	 * @param lunchEndTime
	 */
	public void setLunchEndTime(String lunchEndTime) {
		this.lunchEndTime = lunchEndTime;
	}
	
	
}
