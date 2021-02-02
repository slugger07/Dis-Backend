package sgsits.cse.dis.user.dtos;


import sgsits.cse.dis.user.model.User;

public class UserQualificationDto extends UserProfileDto {

    private String degreeCertificate;

    private int yearOfPassing;

    private String collegeSchool;

    private String universityBoard;

    private String percentageCgpa;

    private String specialization;

    public String getDegreeCertificate() {
        return degreeCertificate;
    }

    public void setDegreeCertificate(final String degreeCertificate) {
        this.degreeCertificate = degreeCertificate;
    }

    public int getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(final int yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public String getCollegeSchool() {
        return collegeSchool;
    }

    public void setCollegeSchool(final String collegeSchool) {
        this.collegeSchool = collegeSchool;
    }

    public String getUniversityBoard() {
        return universityBoard;
    }

    public void setUniversityBoard(final String universityBoard) {
        this.universityBoard = universityBoard;
    }

    public String getPercentageCgpa() {
        return percentageCgpa;
    }

    public void setPercentageCgpa(final String percentageCgpa) {
        this.percentageCgpa = percentageCgpa;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(final String specialization) {
        this.specialization = specialization;
    }
}
