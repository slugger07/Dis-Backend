package sgsits.cse.dis.user.message.response;

public class TaskCategoryResponse {
	private String id;
	private String name;
	
	public TaskCategoryResponse(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public TaskCategoryResponse() {
		super();
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
