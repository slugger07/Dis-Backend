package sgsits.cse.dis.user.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import java.util.Date;

@MappedSuperclass
public class AuditInformation {
  @Column(name = "created_by")
  private String createdBy;
  @Column(name = "created_date")
  private Date createdDate;
  @Column(name = "modified_by")
  private String modifiedBy;
  @Column(name = "modified_date")
  private Date modifiedDate;

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public String getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public Date getModifiedDate() {
    return modifiedDate;
  }

  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }
  
  @PrePersist
  protected void prePersist() {
      if (this.createdDate == null) createdDate = new Date();
  }
}
