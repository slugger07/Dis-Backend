package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class ResourceRequestCategoryForm {
	
	@NotBlank
	private String category;
	
	@NotBlank
	private long assignedPersonId;

	public String getCategory() {
		return category;
	}

	public Long getAssignedPersonId() {
		return assignedPersonId;
	}

	
}
