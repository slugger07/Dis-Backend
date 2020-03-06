package sgsits.cse.dis.academics.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>FacultyTimeTable</b> class.</h1>
 * <p>This class is model for table <b>sem_time_table</b> to act as DAO.
 * This table contains time table settings.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 5-MAR-2020.
 */

@Entity
@Table(name = "faculty_lectures_timetable")
public class FacultyTimetable {

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
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "modified_date")
	private Instant modifiedDate;
	
	@Column(name = "faculty_id")
	private String facultyId;
	
	@Column(name = "sem_time_table_id")
	private String semTimeTableId;
	@Column(name = "room_id")
	private String roomId;
	
	@Column(name = "day")
	private String day;
	
	@Column(name = "start_time")
	private LocalTime startTime;
	
	@Column(name = "end_time")
	private LocalTime endTime;
	
	@Column(name = "batch")
	private String batch;
	
	@Column(name = "with_effect_from")
	private LocalDate withEffectFrom;

	public FacultyTimetable() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FacultyTimetable(String id, String createdBy, Instant createdDate, String modifiedBy, Instant modifiedDate,
			String facultyId, String semTimeTableId, String roomId, String day, LocalTime startTime, LocalTime endTime,
			String batch, LocalDate withEffectFrom) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.facultyId = facultyId;
		this.semTimeTableId = semTimeTableId;
		this.roomId = roomId;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.batch = batch;
		this.withEffectFrom = withEffectFrom;
	}

	public FacultyTimetable(String createdBy, Instant createdDate, String modifiedBy, Instant modifiedDate,
			String facultyId, String semTimeTableId, String roomId, String day, LocalTime startTime, LocalTime endTime,
			String batch, LocalDate withEffectFrom) {
		super();
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.facultyId = facultyId;
		this.semTimeTableId = semTimeTableId;
		this.roomId = roomId;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.batch = batch;
		this.withEffectFrom = withEffectFrom;
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

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public LocalDate getWithEffectFrom() {
		return withEffectFrom;
	}

	public void setWithEffectFrom(LocalDate withEffectFrom) {
		this.withEffectFrom = withEffectFrom;
	}
	
	public String getSemTimeTableId() {
		return semTimeTableId;
	}
	
	public void setSemTimeTableId(String semTimeTableId) {
		this.semTimeTableId = semTimeTableId;
	}
	
	
	
	
}
