package sgsits.cse.dis.administration.response;

public class TelephoneComplaintResponse {
	private int sno;
	private String extensionNo;
	private String location;
	private String details;
	private String createdDate;
	private String dateOfResolution;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getExtensionNo() {
		return extensionNo;
	}
	public void setExtensionNo(String extensionNo) {
		this.extensionNo = extensionNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getDateOfResolution() {
		return dateOfResolution;
	}
	public void setDateOfResolution(String dateOfResolution) {
		this.dateOfResolution = dateOfResolution;
	}
	
}
