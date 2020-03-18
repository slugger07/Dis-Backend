package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class EditComplaintForm {
	@NotBlank
	private String id;
	
	@NotBlank
	private String type;
	
	@NotBlank
	private String status;
	
	@NotBlank
	private String remarks;
	
	@NotBlank
	private String assignedTo;

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getAssignedTo() {
		return assignedTo;
	}
}
