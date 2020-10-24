package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("TELEPHONE")
@Table(name = "telephone_complaints")
public class TelephoneComplaint extends Complaint {

	@Column(name = "location", nullable = false)
	private String location;

	@Column(name = "extension_no")
	private String extensionNo;


	@Column(name = "pdf_id")
	private String pdfId;

	@Column(name = "form_id")
	private String formId;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getExtensionNo() {
		return extensionNo;
	}

	public void setExtensionNo(String extensionNo) {
		this.extensionNo = extensionNo;
	}

	public String getPdfId() {
		return pdfId;
	}

	public void setPdfId(String pdfId) {
		this.pdfId = pdfId;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}
	
}