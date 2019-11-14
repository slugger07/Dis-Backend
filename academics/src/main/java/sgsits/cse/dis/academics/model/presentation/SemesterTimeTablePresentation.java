package sgsits.cse.dis.academics.model.presentation;

import java.sql.Time;

public class SemesterTimeTablePresentation {
	
	private String subjectCode;
	private Time from;
	private Time to;
	private String day;
	private String type;
	private String faculty1;
	private String faculty2;
	private String faculty3;
	private String labTechnician;
	private String ta;
	private String batch;
	private String location;
	private String color;
	
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public Time getFrom() {
		return from;
	}
	public void setFrom(Time from) {
		this.from = from;
	}
	public Time getTo() {
		return to;
	}
	public void setTo(Time to) {
		this.to = to;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFaculty1() {
		return faculty1;
	}
	public void setFaculty1(String faculty1) {
		this.faculty1 = faculty1;
	}
	public String getFaculty2() {
		return faculty2;
	}
	public void setFaculty2(String faculty2) {
		this.faculty2 = faculty2;
	}
	public String getFaculty3() {
		return faculty3;
	}
	public void setFaculty3(String faculty3) {
		this.faculty3 = faculty3;
	}
	public String getLabTechnician() {
		return labTechnician;
	}
	public void setLabTechnician(String labTechnician) {
		this.labTechnician = labTechnician;
	}
	public String getTa() {
		return ta;
	}
	public void setTa(String ta) {
		this.ta = ta;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
