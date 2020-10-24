package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class StudentComplaintForm {
	
	private String studentRollNo;
	private String studentName;
	
	@NotBlank
	private String course;
	
	@NotBlank
	private String year;

	@NotBlank
	private String details;

	public String getStudentRollNo() {
		return studentRollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getCourse() {
		return course;
	}

	public String getYear() {
		return year;
	}

	public String getDetails() {
		return details;
	}
}
