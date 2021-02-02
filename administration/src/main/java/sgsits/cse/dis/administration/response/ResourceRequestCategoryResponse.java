package sgsits.cse.dis.administration.response;

public class ResourceRequestCategoryResponse {

	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
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
	public Long getAssignedPersonID() {
		return assignedPersonID;
	}
	public void setAssignedPersonID(Long assignedPersonID) {
		this.assignedPersonID = assignedPersonID;
	}
	private long createdBy;
	private String createdDate;
	private Long modifiedBy;
	private String modifiedDate;
	private String category;
	private Long assignedPersonID;
	
	
}
