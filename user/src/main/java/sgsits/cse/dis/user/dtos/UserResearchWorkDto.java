package sgsits.cse.dis.user.dtos;


public class UserResearchWorkDto extends UserProfileDto {

    private String title;

    private String category;

    private String subcategory;

    private String journalConferenceName;

    private String publisher;

    private String coAuthors;

    private String guideName;

    private int yearOfPublication;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(final String subcategory) {
        this.subcategory = subcategory;
    }

    public String getJournalConferenceName() {
        return journalConferenceName;
    }

    public void setJournalConferenceName(final String journalConferenceName) {
        this.journalConferenceName = journalConferenceName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(final String publisher) {
        this.publisher = publisher;
    }

    public String getCoAuthors() {
        return coAuthors;
    }

    public void setCoAuthors(final String coAuthors) {
        this.coAuthors = coAuthors;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(final String guideName) {
        this.guideName = guideName;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(final int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
