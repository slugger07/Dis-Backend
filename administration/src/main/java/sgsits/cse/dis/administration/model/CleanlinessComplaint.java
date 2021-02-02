package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CLEANLINESS")
@Table(name="cleanliness_complaints")
public class CleanlinessComplaint  extends Complaint{
	
	@Column(name="location")
	private String location;
	
	@Column(name="level_of_dust")
	private int levelOfDust;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getLevelOfDust() {
		return levelOfDust;
	}
	public void setLevelOfDust(int levelOfDust) {
		this.levelOfDust = levelOfDust;
	}
	
	
}
