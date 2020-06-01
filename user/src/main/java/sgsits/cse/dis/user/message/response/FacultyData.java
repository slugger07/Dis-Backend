package sgsits.cse.dis.user.message.response;

/**
 * <h1></h1>class.
 * This class is pojo form for return java object as a response to request over network.
 *
 * @author Devyani garg
 * @since 8-DEC-2018
 */
public class FacultyData {

    private String id;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAcronym() {
        return nameAcronym;
    }

    public void setNameAcronym(String nameAcronym) {
        this.nameAcronym = nameAcronym;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getCurrentDesignation() {
        return currentDesignation;
    }

    public void setCurrentDesignation(String currentDesignation) {
        this.currentDesignation = currentDesignation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Long getAlternateMobileNo() {
        return alternateMobileNo;
    }

    public void setAlternateMobileNo(Long alternateMobileNo) {
        this.alternateMobileNo = alternateMobileNo;
    }
}
