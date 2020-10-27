package sgsits.cse.dis.user.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ug_project_details")
public class UgProjectDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "batch_id")
    private String batchId;

    @Column(name = "enrollment_id")
    private String enrollmentId;

    @Column(name = "guide")
    private String guide;

    @Column(name = "co-guide")
    private String coguide;

    @Column(name = "link_to_evaluation_sheet")
    private String linkToEvaluationSheet;

    @Column(name = "topic")
    private String topic;

    @Column(name = "session")
    private String session;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(final Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(final String batchId) {
        this.batchId = batchId;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(final String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(final String guide) {
        this.guide = guide;
    }

    public String getCoguide() {
        return coguide;
    }

    public void setCoguide(final String coguide) {
        this.coguide = coguide;
    }

    public String getLinkToEvaluationSheet() {
        return linkToEvaluationSheet;
    }

    public void setLinkToEvaluationSheet(final String linkToEvaluationSheet) {
        this.linkToEvaluationSheet = linkToEvaluationSheet;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(final String topic) {
        this.topic = topic;
    }

    public String getSession() {
        return session;
    }

    public void setSession(final String session) {
        this.session = session;
    }
}
