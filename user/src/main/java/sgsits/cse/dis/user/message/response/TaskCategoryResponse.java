package sgsits.cse.dis.user.message.response;
/**
 * <h1>TaskCategoryResponse</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Arjit Mishra.
 * @since 27-JAN-2020
 */
public class TaskCategoryResponse {
	private String id;
	private String name;
	
	public TaskCategoryResponse() {
		super();
	}
	
	public TaskCategoryResponse(String id, String name) {
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
