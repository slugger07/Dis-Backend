package sgsits.cse.dis.user.model;

public class StudentAttendancePercentage {
	
	private String enrollmentId;
	private String subjectCode;
	private float theoryPercent;
	private float practicalPercent;
	private float totaltheorylecture;
	private float totalpracticallecture;
	
	public StudentAttendancePercentage()
	{}
	
	public StudentAttendancePercentage(String enrollmentId, String subjectCode, float theoryPercent,
			float practicalPercent, float totaltheoryPercent, float totalpracticalPercent) {
		super();
		this.enrollmentId = enrollmentId;
		this.subjectCode = subjectCode;
		this.theoryPercent = theoryPercent;
		this.practicalPercent = practicalPercent;
		this.totaltheorylecture = totaltheoryPercent;
		this.totalpracticallecture = totalpracticalPercent;
	}

	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public float getTheoryPercent() {
		return theoryPercent;
	}
	public void setTheoryPercent(float theoryPercent) {
		this.theoryPercent = theoryPercent;
	}
	public float getPracticalPercent() {
		return practicalPercent;
	}
	public void setPracticalPercent(float practicalPercent) {
		this.practicalPercent = practicalPercent;
	}

	public float getTotaltheorylecture() {
		return totaltheorylecture;
	}

	public void setTotaltheorylecture(float totaltheorylecture) {
		this.totaltheorylecture = totaltheorylecture;
	}

	public float getTotalpracticallecture() {
		return totalpracticallecture;
	}

	public void setTotalpracticallecture(float totalpracticallecture) {
		this.totalpracticallecture = totalpracticallecture;
	}
}
