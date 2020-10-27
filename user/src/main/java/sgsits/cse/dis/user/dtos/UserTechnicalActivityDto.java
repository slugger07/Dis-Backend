package sgsits.cse.dis.user.dtos;


import java.util.Date;

public class UserTechnicalActivityDto extends UserProfileDto {

    private String type;

    private String topicSubject;

    private Date fromDate;

    private Date toDate;

    private String nameOfCoordinator;

    private String attendedOrganized;

    private String place;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getTopicSubject() {
        return topicSubject;
    }

    public void setTopicSubject(final String topicSubject) {
        this.topicSubject = topicSubject;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(final Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(final Date toDate) {
        this.toDate = toDate;
    }

    public String getNameOfCoordinator() {
        return nameOfCoordinator;
    }

    public void setNameOfCoordinator(final String nameOfCoordinator) {
        this.nameOfCoordinator = nameOfCoordinator;
    }

    public String getAttendedOrganized() {
        return attendedOrganized;
    }

    public void setAttendedOrganized(final String attendedOrganized) {
        this.attendedOrganized = attendedOrganized;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(final String place) {
        this.place = place;
    }
}
