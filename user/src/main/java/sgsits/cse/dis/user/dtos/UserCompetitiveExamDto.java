package sgsits.cse.dis.user.dtos;

import java.util.Date;

public class UserCompetitiveExamDto extends UserProfileDto {


    private String nameOfExam;

    private double score;

    private int rank;

    private Date year;

    private byte[] scoreCard;

    public String getNameOfExam() {
        return nameOfExam;
    }

    public void setNameOfExam(final String nameOfExam) {
        this.nameOfExam = nameOfExam;
    }

    public double getScore() {
        return score;
    }

    public void setScore(final double score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(final int rank) {
        this.rank = rank;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(final Date year) {
        this.year = year;
    }

    public byte[] getScoreCard() {
        return scoreCard;
    }

    public void setScoreCard(final byte[] scoreCard) {
        this.scoreCard = scoreCard;
    }
}
