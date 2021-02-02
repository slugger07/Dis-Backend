package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class FacultyComplaintForm {

	@NotBlank
	private String facultyName;
	
	@NotBlank
	private String details;

	public String getFacultyName() {
		return facultyName;
	}

	public String getDetails() {
		return details;
	}
}
