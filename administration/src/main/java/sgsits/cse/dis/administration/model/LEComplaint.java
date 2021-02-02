package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("LE")
@Table(name="lab_equipment_complaints")
public class LEComplaint extends Complaint {
	
	@Column(name="lab")
	private String lab;
	
	@Column(name="system_no")
	private String systemNo;
	
	public String getLab() {
		return lab;
	}
	public void setLab(String lab) {
		this.lab = lab;
	}
	public String getSystemNo() {
		return systemNo;
	}
	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}
	
	
}
