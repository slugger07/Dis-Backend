package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "engineering_cell_and_central_workshop_complaints")
@DiscriminatorValue("ECCW")
public class ECCWComplaint extends Complaint {
	

	@Column(name = "pdf_id")
	private String pdfId;

	@Column(name = "form_id")
	private String formId;
	
	@Column(name = "location")
	private String location;
	
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
}
