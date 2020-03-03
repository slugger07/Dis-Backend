package sgsits.cse.dis.academics.response;

/**
 * <h1>InfrastructureResponse</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Arjit Mishra
 * @since 2-MAR-2020
 */
public class InfrastructureResponse {
	private String id;
	private String name;
	private String nameAcronym;
	
	
	public InfrastructureResponse(String id, String name, String nameAcronym) {
		super();
		this.id = id;
		this.name = name;
		this.nameAcronym = nameAcronym;
	}
	public InfrastructureResponse() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getNameAcronym() {
		return nameAcronym;
	}
	public void setNameAcronym(String nameAcronym) {
		this.nameAcronym = nameAcronym;
	}

	
	
	
}