package sgsits.cse.dis.user.message.response;

public class CategorySpecificTaskResponse {
	private String id;
	private String name;
	
	public CategorySpecificTaskResponse(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public CategorySpecificTaskResponse() {
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
