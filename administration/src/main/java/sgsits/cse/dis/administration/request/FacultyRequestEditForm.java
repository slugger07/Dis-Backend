package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class FacultyRequestEditForm {
	
	@NotBlank
	private String assignedPersonId;

	public String getAssignedPersonId() {
		return assignedPersonId;
	}

	public void setAssignedPersonId(String assignedPersonId) {
		this.assignedPersonId = assignedPersonId;
	}
	
	

}
