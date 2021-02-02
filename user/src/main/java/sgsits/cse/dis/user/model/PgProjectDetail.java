package sgsits.cse.dis.user.model;

import javax.persistence.*;

@Entity
@Table(name = "pg_project_details")
public class PgProjectDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    private String createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private String modifiedDate;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "enrollment_no")
    private String EnrollmentNo;

    @Column(name = "area")
    private String area;

    @Column(name = "title")
    private String title;

    @Column(name = "guide")
    private String guide;

    @Column(name = "coguide")
    private String coGuide;

    @Column(name = "session")
    private String session;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(final String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getEnrollmentNo() {
        return EnrollmentNo;
    }

    public void setEnrollmentNo(final String enrollmentNo) {
        EnrollmentNo = enrollmentNo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(final String area) {
        this.area = area;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(final String guide) {
        this.guide = guide;
    }

    public String getCoGuide() {
        return coGuide;
    }

    public void setCoGuide(final String coGuide) {
        this.coGuide = coGuide;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
