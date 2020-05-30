package sgsits.cse.dis.infrastructure.response;
/**
 * <h1>ActiveStaffListResponse</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Arjit Mishra
 * @since 27-JAN-2020
 */
public class ActiveStaffListResponse {
	private String id;
	private String name;
	private String email;
	
	public ActiveStaffListResponse() {
		super();
	}

	
	public ActiveStaffListResponse(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
