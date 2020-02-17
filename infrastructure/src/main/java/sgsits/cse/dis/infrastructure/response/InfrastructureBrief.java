package sgsits.cse.dis.infrastructure.response;

/**
 * <h1>InfrastructureBrief</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Devyani garg
 * @since 8-DEC-2018
 */
public class InfrastructureBrief {
	private String id;
	private String name;
	private String area;
	private String nameAcronym;
	private String location;
	private String incharge;
	private String associateIncharge;
	private String staff;
	private String attendent;
	
	
	public InfrastructureBrief() {
		super();
	}
	
	public InfrastructureBrief(String id, String name, String area, String nameAcronym, String location,
			String incharge, String associateIncharge, String staff, String attendent) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.nameAcronym = nameAcronym;
		this.location = location;
		this.incharge = incharge;
		this.associateIncharge = associateIncharge;
		this.staff = staff;
		this.attendent = attendent;
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
	public String getNameAcronym() {
		return nameAcronym;
	}
	public void setNameAcronym(String nameAcronym) {
		this.nameAcronym = nameAcronym;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIncharge() {
		return incharge;
	}
	public void setIncharge(String incharge) {
		this.incharge = incharge;
	}
	public String getAssociateIncharge() {
		return associateIncharge;
	}
	public void setAssociateIncharge(String associateIncharge) {
		this.associateIncharge = associateIncharge;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getAttendent() {
		return attendent;
	}
	public void setAttendent(String attendent) {
		this.attendent = attendent;
	}
	
	
}