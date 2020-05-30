package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "resource_request_category")
public class FacultyRequest {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id")
	private String id;
	
	@Column(name = "created_by", nullable = false)
	private String createdBy;
	
	@Column(name = "created_date", nullable = false)
	private String createdDate;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "modified_date")
	private String modifiedDate;
	
	@Column(name = "category", nullable = false)
	private String category;
	
	@Column(name = "assigned_person_id", nullable = false)
	private String assignedPersonId;

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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAssignedPersonId() {
		return assignedPersonId;
	}

	public void setAssignedPersonId(String assignedPersonId) {
		this.assignedPersonId = assignedPersonId;
	}

	@Override
	public String toString() {
		return "FacultyRequest [id=" + id + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", category=" + category
				+ ", assignedPersonId=" + assignedPersonId + "]";
	}
	
	
}
