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
     * The Type list.
     */
    private List<String> typeList;

    /**
     * Instantiates a new Send notification request dto.
     *
     * @param notification the notification
     * @param usernameList the participants
     * @param typeList     the type list
     */
    public SendNotificationRequestDto(final Notification notification, final List<String> usernameList, final List<String> typeList) {
        this.notification = notification;
        this.usernameList = usernameList;
        this.typeList = typeList;
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

    /**
     * Gets type list.
     *
     * @return the type list
     */
    public List<String> getTypeList() {
        return typeList;
    }

    /**
     * Sets type list.
     *
     * @param typeList the type list
     */
    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }
}
