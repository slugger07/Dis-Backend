package sgsits.cse.dis.infrastructure.request;

public class UpdateInfraInchargeDetail {
	private String locationId;
	private String inchargeId;
	private String inchargeName;
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getInchargeId() {
		return inchargeId;
	}
	public void setInchargeId(String inchargeId) {
		this.inchargeId = inchargeId;
	}
	public String getInchargeName() {
		return inchargeName;
	}
	public void setInchargeName(String inchargeName) {
		this.inchargeName = inchargeName;
	}
}
