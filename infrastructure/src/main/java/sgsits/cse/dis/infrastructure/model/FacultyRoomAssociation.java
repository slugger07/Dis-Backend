package sgsits.cse.dis.infrastructure.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>FacultyRoomAssociation</b> class.</h1>
 * <p>This class is model for table <b>faculty_room_rassociation</b> to act as DAO.
 * This table contains relation between userId and roomId to show which faculty is assigned to which room.
 * @author Arjit Mishra,Devyani garg.
 * @version 1.0.
 * @since 25-JAN-2020.
 */
@Entity
@Table(name = "faculty_room_association")
public class FacultyRoomAssociation {
	
	
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
	
	@Column(name = "room_id")
	private String roomId;
	
	@Column(name = "user_id")
	private String facultyId;
	
	@Column(name = "status")
	private String status;

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

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
