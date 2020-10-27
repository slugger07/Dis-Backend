package sgsits.cse.dis.infrastructure.request;

public class UpdateInfraInchargeDetail {
	private String locationId;
	private String newIncharge;
	private String inchargeName;
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	public String getNewIncharge() {
		return newIncharge;
	}
	public void setNewIncharge(String newIncharge) {
		this.newIncharge = newIncharge;
	}
	public String getInchargeName() {
		return inchargeName;
	}
	public void setInchargeName(String inchargeName) {
		this.inchargeName = inchargeName;
	}
}