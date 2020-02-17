package sgsits.cse.dis.user.message.response;
/**
 * <h1>CategorySpecificTaskResponse</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Devyani garg
 * @since 27-JAN-2020
 */
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
