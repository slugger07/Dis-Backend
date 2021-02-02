package sgsits.cse.dis.user.model;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "staff_duties")
public class StaffDuty {

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

    @Column(name = "user_id")
    private String userId;

    @Column(name = "inside_outside")
    private String insideOutside;

    @Column(name = "to_date")
    private Date toDate;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "duty_description")
    private String dutyDescription;

    @Column(name = "place")
    private String place;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getInsideOutside() {
        return insideOutside;
    }

    public void setInsideOutside(final String insideOutside) {
        this.insideOutside = insideOutside;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(final Date toDate) {
        this.toDate = toDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(final Date fromDate) {
        this.fromDate = fromDate;
    }

    public String getDutyDescription() {
        return dutyDescription;
    }

    public void setDutyDescription(final String dutyDescription) {
        this.dutyDescription = dutyDescription;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(final String place) {
        this.place = place;
    }
}
