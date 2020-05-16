package sgsits.cse.dis.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "pg_guide_allotment_guide_details")
public class PgGuideAllotmentGuide {
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true)
	private String id;
	
	@Column(name = "batch_id", nullable = false)
	private String batchId;
	
	@Column(name = "guide_id")
	private String guideId;
	
	@Column(name = "co_guide_id")
	private String coGuideId;
	
	@Column(name = "session")
	private String session;
	
	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "modified_Date")
	private String modifiedDate;

	public PgGuideAllotmentGuide() {
		super();
	}

	public PgGuideAllotmentGuide(String batchId, String guideId, String coGuideId,String session,String createdBy,String createdDate) {
		super();
		this.batchId = batchId;
		this.guideId = guideId;
		this.coGuideId = coGuideId;
		this.session = session;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getGuideId() {
		return guideId;
	}

	public void setGuideId(String guideId) {
		this.guideId = guideId;
	}

	public String getCoGuideId() {
		return coGuideId;
	}

	public void setCoGuideId(String coGuideId) {
		this.coGuideId = coGuideId;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
