package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class ECCWComplaintForm {

	@NotBlank
	private String location;
	
	@NotBlank
	private String details;

	public String getLocation() {
		return location;
	}

	public String getDetails() {
		return details;
	}
}
