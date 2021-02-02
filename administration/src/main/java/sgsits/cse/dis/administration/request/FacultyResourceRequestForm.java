package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class FacultyResourceRequestForm {

	@NotBlank
	private String resourceCategory;
	
	@NotBlank
	private String details;
	
	@NotBlank
	private String priority;
	
	@NotBlank
	private String deadlineOfResolution;


	public String getResourceCategory() {
		return resourceCategory;
	}

	public String getPriority() {
		return priority;
	}

	public String getDeadlineOfResolution() {
		return deadlineOfResolution;
	}

	public String getDetails() {
		return details;
	}
	
	
}
