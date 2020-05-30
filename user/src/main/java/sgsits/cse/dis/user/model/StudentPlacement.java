package sgsits.cse.dis.user.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "student_placement")
public class StudentPlacement {
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

    @Column(name = "enrollment_id")
    private String enrollmentId;

    @Column(name = "joining_location")
    private String joiningLocation;

    @Column(name = "joining_status")
    private String joiningStatus;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "campus_type")
    private String campusType;

    @Column(name = "package")
    private Double ctc;

    @Column(name = "user_id")
    private String userId;

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

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(final String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getJoiningLocation() {
        return joiningLocation;
    }

    public void setJoiningLocation(final String joiningLocation) {
        this.joiningLocation = joiningLocation;
    }

    public String getJoiningStatus() {
        return joiningStatus;
    }

    public void setJoiningStatus(final String joiningStatus) {
        this.joiningStatus = joiningStatus;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public String getCampusType() {
        return campusType;
    }

    public void setCampusType(final String campusType) {
        this.campusType = campusType;
    }

    public Double getCtc() {
        return ctc;
    }

    public void setCtc(final Double ctc) {
        this.ctc = ctc;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }
}
