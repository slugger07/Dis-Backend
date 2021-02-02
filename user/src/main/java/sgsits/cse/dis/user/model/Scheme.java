package sgsits.cse.dis.user.model;

import java.sql.Date;

public class Scheme {

    private long id;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private String courseId;
    private String session;
    private String year;
    private String semester;
    private String subjectCode;
    private String subjectName;
    private String subjectAcronym;
    private int noOfLecturePeriods;
    private int noOfTutorialPeriods;
    private int noOfPracticalPeriods;
    private int noOfTheoryCredits;
    private int noOfPracticalCredits;
    private int noOfCreditsTotal;
    private int maxTheoryMarks;
    private int maxCw;
    private int maxPracticalMarks;
    private int maxSw;
    private int maxTotal;
    private String syllabusPdf;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectAcronym() {
        return subjectAcronym;
    }

    public void setSubjectAcronym(String subjectAcronym) {
        this.subjectAcronym = subjectAcronym;
    }

    public int getNoOfLecturePeriods() {
        return noOfLecturePeriods;
    }

    public void setNoOfLecturePeriods(int noOfLecturePeriods) {
        this.noOfLecturePeriods = noOfLecturePeriods;
    }

    public int getNoOfTutorialPeriods() {
        return noOfTutorialPeriods;
    }

    public void setNoOfTutorialPeriods(int noOfTutorialPeriods) {
        this.noOfTutorialPeriods = noOfTutorialPeriods;
    }

    public int getNoOfPracticalPeriods() {
        return noOfPracticalPeriods;
    }

    public void setNoOfPracticalPeriods(int noOfPracticalPeriods) {
        this.noOfPracticalPeriods = noOfPracticalPeriods;
    }

    public int getNoOfTheoryCredits() {
        return noOfTheoryCredits;
    }

    public void setNoOfTheoryCredits(int noOfTheoryCredits) {
        this.noOfTheoryCredits = noOfTheoryCredits;
    }

    public int getNoOfPracticalCredits() {
        return noOfPracticalCredits;
    }

    public void setNoOfPracticalCredits(int noOfPracticalCredits) {
        this.noOfPracticalCredits = noOfPracticalCredits;
    }

    public int getNoOfCreditsTotal() {
        return noOfCreditsTotal;
    }

    public void setNoOfCreditsTotal(int noOfCreditsTotal) {
        this.noOfCreditsTotal = noOfCreditsTotal;
    }

    public int getMaxTheoryMarks() {
        return maxTheoryMarks;
    }

    public void setMaxTheoryMarks(int maxTheoryMarks) {
        this.maxTheoryMarks = maxTheoryMarks;
    }

    public int getMaxCw() {
        return maxCw;
    }

    public void setMaxCw(int maxCw) {
        this.maxCw = maxCw;
    }

    public int getMaxPracticalMarks() {
        return maxPracticalMarks;
    }

    public void setMaxPracticalMarks(int maxPracticalMarks) {
        this.maxPracticalMarks = maxPracticalMarks;
    }

    public int getMaxSw() {
        return maxSw;
    }

    public void setMaxSw(int maxSw) {
        this.maxSw = maxSw;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public String getSyllabusPdf() {
        return syllabusPdf;
    }

    public void setSyllabusPdf(String syllabusPdf) {
        this.syllabusPdf = syllabusPdf;
    }
}
