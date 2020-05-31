package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class FacultyRequestForm {
	
	@NotBlank
	private String category;
	
	@NotBlank
	private String details;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
