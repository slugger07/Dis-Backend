package sgsits.cse.dis.user.dtos;

public class FacultyDataDto {

    private String id;
    private String userId;
    private String name;
    private String nameAcronym;
    private String profilePicture;
    private String currentDesignation;
    private String email;
    private Long mobileNo;
    private Long alternateMobileNo;


    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getNameAcronym() {
        return nameAcronym;
    }

    public void setNameAcronym(final String nameAcronym) {
        this.nameAcronym = nameAcronym;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(final String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getCurrentDesignation() {
        return currentDesignation;
    }

    public void setCurrentDesignation(final String currentDesignation) {
        this.currentDesignation = currentDesignation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(final Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getAlternateMobileNo() {
        return alternateMobileNo;
    }

    public void setAlternateMobileNo(final Long alternateMobileNo) {
        this.alternateMobileNo = alternateMobileNo;
    }
}
