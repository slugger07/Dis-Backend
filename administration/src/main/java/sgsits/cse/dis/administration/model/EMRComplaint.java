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
	private String form_id;
	
	@Column(name="pdf_id")
	private String pdf_id;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getForm_id() {
		return form_id;
	}

	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}

	public String getPdf_id() {
		return pdf_id;
	}

	public void setPdf_id(String pdf_id) {
		this.pdf_id = pdf_id;
	}
	
	
}
