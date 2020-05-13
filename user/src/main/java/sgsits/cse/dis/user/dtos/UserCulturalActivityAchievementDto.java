package sgsits.cse.dis.user.dtos;


import java.util.Date;

public class UserCulturalActivityAchievementDto extends UserProfileDto {

    private String type;

    private String nameOfActivity;

    private String achievement;

    private Date date;

    private byte[] certificate;

    private String place;

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
