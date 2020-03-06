package sgsits.cse.dis.academics.request;

import java.util.ArrayList;
import java.util.List;

import sgsits.cse.dis.academics.model.FacultyTimetable;

/**
 * <h1><b>FacultyTimeTable</b> class.</h1>
 *  * This class is pojo form for converting json and mapping into this java object
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 5-MAR-2020.
 */
public class FacultyTimeTableForm {

	private String subjectCode;
	private String lectureType;
	private String year;
	private String semester;
	private String session;
	private String course;
	
//	private String facultyId;
//	private String roomId;
//	private String day;
//	private Instant startTime;
//	private Instant endTime;
//	private Instant withEffectFrom;
	
	private List<FacultyTimetable> facultyTimeTableEntries = new ArrayList<>();
	
	public FacultyTimeTableForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacultyTimeTableForm(String subjectCode, String lectureType, String year, String semester, String session, List<FacultyTimetable> facultyTimeTableEntries) {
		super();
		this.subjectCode = subjectCode;
		this.lectureType = lectureType;
		this.year = year;
		this.semester = semester;
		this.session = session;
		this.facultyTimeTableEntries = facultyTimeTableEntries;
	}


	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getLectureType() {
		return lectureType;
	}

	public void setLectureType(String lectureType) {
		this.lectureType = lectureType;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public List<FacultyTimetable> getFacultyTimeTableEntries() {
		return facultyTimeTableEntries;
	}

	public void setFacultyTimeTableEntries(List<FacultyTimetable> facultyTimeTableEntries) {
		this.facultyTimeTableEntries = facultyTimeTableEntries;
	}

	
	
}
