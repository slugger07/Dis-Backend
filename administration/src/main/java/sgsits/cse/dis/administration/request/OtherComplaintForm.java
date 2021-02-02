package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class OtherComplaintForm {
	@NotBlank
	private String details;
	private String assignedTo;

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDetails() {
		return details;
	}
}
