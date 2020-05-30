package sgsits.cse.dis.user.dtos;


import java.util.Date;

public class UserProjectDto extends UserProfileDto {

    private Date toDate;

    private Date fromDate;

    private String title;

    private String description;

    private String guide;

    private String otherCreators;

    private String role;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(final String guide) {
        this.guide = guide;
    }

    public String getOtherCreators() {
        return otherCreators;
    }

    public void setOtherCreators(final String otherCreators) {
        this.otherCreators = otherCreators;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }
}
