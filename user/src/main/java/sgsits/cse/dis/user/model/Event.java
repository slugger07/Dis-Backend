package sgsits.cse.dis.user.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "event")
public class Event implements Serializable {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name="UUID",
			strategy="org.hibernate.id.UUIDGenerator"
		)
	@Column(name = "event_id", nullable = false, unique = true)
	private String eventId;
	
	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_date")
	private Date modifiedDate;
	
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "description")
	private String description;

	@Column(name = "start_date", nullable = false)
	private Date startDate;
	
	@Column(name = "end_date", nullable = false)
	private Date endDate;
	
	@Column(name = "event_type")
	private String eventType;
	
	@Column(name = "event_incharge")
	private String eventIncharge;

	@OneToMany(targetEntity = EventParticipant.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id", referencedColumnName = "event_id")
	private Set<EventParticipant> participants;

	public Event() {}

	public Event(String eventId, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String title, String description, Date startDate, Date endDate, String eventType, String eventIncharge, Set<EventParticipant> participants) {
		super();
		this.eventId = eventId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.eventType = eventType;
		this.eventIncharge = eventIncharge;
		this.participants = participants;
		this.location = location;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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


	public Set<EventParticipant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<EventParticipant> participants) {
		this.participants = participants;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventIncharge() {
		return eventIncharge;
	}

	public void setEventIncharge(String eventIncharge) {
		this.eventIncharge = eventIncharge;
	}
}





