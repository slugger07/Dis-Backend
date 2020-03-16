package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class OtherComplaintForm {
	@NotBlank
	private String details;

	public String getDetails() {
		return details;
	}
}
