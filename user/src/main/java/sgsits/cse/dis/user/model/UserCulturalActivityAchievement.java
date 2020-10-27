package sgsits.cse.dis.user.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user_cultural_activity_achievements")
public class UserCulturalActivityAchievement {

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

    @Column(name = "type")
    private String type;

    @Column(name = "name_of_activity")
    private String nameOfActivity;

    @Column(name = "achievement")
    private String achievement;

    @Column(name = "date")
    private Date date;

    @Column(name = "certificate")
    private byte[] certificate;

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

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getNameOfActivity() {
        return nameOfActivity;
    }

    public void setNameOfActivity(final String nameOfActivity) {
        this.nameOfActivity = nameOfActivity;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(final String achievement) {
        this.achievement = achievement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(final byte[] certificate) {
        this.certificate = certificate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(final String place) {
        this.place = place;
    }
}
