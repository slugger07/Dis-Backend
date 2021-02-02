package sgsits.cse.dis.infrastructure.response;

public class FacultyNameListResponse {
	private String id;
	private String name;
	
	public FacultyNameListResponse() {
		super();
	}
	
	public FacultyNameListResponse(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
