package sgsits.cse.dis.user.dtos;

public class FacultyBriefDataDto {

    private String name;
    private String nameAcronym;
    private String profilePicture;
    private String currentDesignation;
    private String email;

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
}
