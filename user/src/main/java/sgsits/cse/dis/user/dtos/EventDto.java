package sgsits.cse.dis.user.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import sgsits.cse.dis.user.model.EventParticipant;

import java.util.Date;
import java.util.Set;

public class EventDto {
    String eventId;
    String createdBy;
    Date createdDate;
    Date startDate;
    Date endDate;
    String description;
    String eventIncharge;
    String location;
    Set<EventParticipant> participants;
    String title;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventIncharge() {
        return eventIncharge;
    }

    public void setEventIncharge(String eventIncharge) {
        this.eventIncharge = eventIncharge;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<EventParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<EventParticipant> participants) {
        this.participants = participants;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}