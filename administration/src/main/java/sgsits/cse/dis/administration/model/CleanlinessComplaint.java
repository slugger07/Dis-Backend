package sgsits.cse.dis.administration.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CLEANLINESS")
@Table(name="cleanliness_complaints")
public class CleanlinessComplaint  extends Complaints{
	private String location;
	private int level_of_dust;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getLevel_of_dust() {
		return level_of_dust;
	}
	public void setLevel_of_dust(int level_of_dust) {
		this.level_of_dust = level_of_dust;
	}
	
}
