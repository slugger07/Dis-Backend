package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("STUDENT")
@Table(name = "student_complaints")
public class StudentComplaint extends Complaint {

	@Column(name = "rollno")
	private String rollNo;

	@Column(name = "name")
	private String name;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "course")
	private String course;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	
}
