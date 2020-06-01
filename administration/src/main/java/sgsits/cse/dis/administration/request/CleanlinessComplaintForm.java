package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;
/**
 * <h1>CleanlinessComplaintForm</h1>class.
 * This class is pojo form for converting json and mapping into this java object
 * @author Arjit Mishra
 * @since 2-DEC-2020
 */
public class CleanlinessComplaintForm {

	@NotBlank
	private String location;
	
	@NotBlank
	private String details;
	
	@NotBlank
	private int levelOfDust;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getLevelOfDust() {
		return levelOfDust;
	}
	public void setLevelOfDust(int levelOfDust) {
		this.levelOfDust = levelOfDust;
	}
	
}
