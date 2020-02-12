package sgsits.cse.dis.infrastructure.response;

public class RoomAssociationData {
	private Long id;
	private String name;
	private String area;
	private String location;
	private String[] AssociatedTo;
	public String[] getAssociatedTo() {
		return AssociatedTo;
	}
	public void setAssociatedTo(String[] associatedTo) {
		AssociatedTo = associatedTo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
