package sgsits.cse.dis.user.dto;

import sgsits.cse.dis.user.model.Notification;

import java.util.List;

/**
 * The type Send notification request dto.
 */
public class SendNotificationRequestDto {
    /**
     * The Notification.
     */
    private Notification notification;
    /**
     * The Participants.
     */
    private List<String> usernameList;

    /**
     * Instantiates a new Send notification request dto.
     *
     * @param notification the notification
     * @param usernameList the participants
     */
    public SendNotificationRequestDto(Notification notification, List<String> usernameList) {
        this.notification = notification;
        this.usernameList = usernameList;
    }

    /**
     * Gets notification.
     *
     * @return the notification
     */
    public Notification getNotification() {
        return notification;
    }

    /**
     * Sets notification.
     *
     * @param notification the notification
     */
    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    /**
     * Gets participants.
     *
     * @return the participants
     */
    public List<String> getUsernameList() {
        return usernameList;
    }

    /**
     * Sets participants.
     *
     * @param usernameList the participants
     */
    public void setUsernameList(List<String> usernameList) {
        this.usernameList = usernameList;
    }
}
