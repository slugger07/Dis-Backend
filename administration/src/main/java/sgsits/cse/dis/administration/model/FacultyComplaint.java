package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("FACULTY")
@Table(name = "faculty_complaints")
public class FacultyComplaint extends Complaint{

	@Column(name = "faculty_name")
	private String facultyName;

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	

}
