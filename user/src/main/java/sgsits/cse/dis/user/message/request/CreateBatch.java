package sgsits.cse.dis.user.message.request;

import java.util.List;

import sgsits.cse.dis.user.model.StaffProfile;
import sgsits.cse.dis.user.model.StudentProfile;

public class CreateBatch {
	private List<StudentProfile> students;
	private StaffProfile guide,coguide;
	private String session;
	private String ugOrPg;
	
	public CreateBatch(List<StudentProfile> students, StaffProfile guide, StaffProfile coguide, String session,
			String ugOrPg) {
		super();
		this.students = students;
		this.guide = guide;
		this.coguide = coguide;
		this.session = session;
		this.ugOrPg = ugOrPg;
	}

	public List<StudentProfile> getStudents() {
		return students;
	}

	public void setStudents(List<StudentProfile> students) {
		this.students = students;
	}

	public StaffProfile getGuide() {
		return guide;
	}

	public void setGuide(StaffProfile guide) {
		this.guide = guide;
	}

	public StaffProfile getCoguide() {
		return coguide;
	}

	public void setCoguide(StaffProfile coguide) {
		this.coguide = coguide;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getUgOrPg() {
		return ugOrPg;
	}

	public void setUgOrPg(String ugOrPg) {
		this.ugOrPg = ugOrPg;
	}
	
	
}
