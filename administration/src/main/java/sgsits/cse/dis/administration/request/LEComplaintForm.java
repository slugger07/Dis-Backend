package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class LEComplaintForm {
	
	@NotBlank
	private String lab;
	
	@NotBlank
	private String systemNo;
	
	@NotBlank
	private String details;

	public String getLab() {
		return lab;
	}

	public String getSystemNo() {
		return systemNo;
	}

	public String getDetails() {
		return details;
	}
}
