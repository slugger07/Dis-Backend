package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class FacultyRequestForm {
	
	@NotBlank
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
