package sgsits.cse.dis.user.dtos;


import java.util.Date;

public class UserWorkExperienceDto extends UserProfileDto {

    private String organizationName;

    private String designation;

    private Date dateOfJoining;

    private Date dateOfLeaving;

    private Long payScale;

    private String country;

    private String state;

    private String city;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(final String organizationName) {
        this.organizationName = organizationName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(final String designation) {
        this.designation = designation;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(final Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Date getDateOfLeaving() {
        return dateOfLeaving;
    }

    public void setDateOfLeaving(final Date dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
    }

    public Long getPayScale() {
        return payScale;
    }

    public void setPayScale(final Long payScale) {
        this.payScale = payScale;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }
}
