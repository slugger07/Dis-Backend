package sgsits.cse.dis.infrastructure.response;
/**
 * <h1>RoomAssociationData</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Devyani garg
 * @since 8-DEC-2018
 */
public class RoomAssociationData {
	private String id;
	private String name;
	private String area;
	private String location;
	private String[] associatedTo;
	
	public RoomAssociationData() {
		super();
	}

	public RoomAssociationData(String id, String name, String area, String location) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.location = location;
	}

	public String[] getAssociatedTo() {
		return associatedTo;
	}
	public void setAssociatedTo(String[] associatedTo) {
		this.associatedTo = associatedTo;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
