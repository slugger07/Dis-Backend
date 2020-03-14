package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("EMR")
@Table(name="electrical_maintenance_and_repairs_section_complaints")
public class EMRComplaint extends Complaint {

	@Column(name="location")
	private String location;
	
	@Column(name="form_id")
	private String formId;
	
	@Column(name="pdf_id")
	private String pdfId;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getPdfId() {
		return pdfId;
	}

	public void setPdfId(String pdfId) {
		this.pdfId = pdfId;
	}

		
}
