package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;
/**
 * <h1>AddThesisForm</h1>class.
 * This class is pojo form for converting json and mapping into this java object
 * @author Arjit Mishra
 * @since 2-DEC-2020
 */
public class AddThesisForm {
	
	private String year;
	
	@NotBlank(message = "Submitted By cannot be empty.")
	private String submittedBy;
	
	@NotBlank(message = "Guided By cannot be empty.")
	private String guidedBy;
	
	private String cdStatus;
	
	@NotBlank(message = "Course cannot be empty.")
	private String course;
	
	@NotBlank(message = "Title cannot be empty.")
	private String title;
	
	private String remarks;

	public String getYear() {
		return year;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public String getGuidedBy() {
		return guidedBy;
	}

	public String getCdStatus() {
		return cdStatus;
	}

	public String getCourse() {
		return course;
	}

	public String getTitle() {
		return title;
	}

	public String getRemarks() {
		return remarks;
	}
	
	
	
	
	

}
