package sgsits.cse.dis.user.service;

import sgsits.cse.dis.user.model.Notification;
import sgsits.cse.dis.user.model.NotificationParticipant;
import sgsits.cse.dis.user.model.User;

import java.util.List;

/**
 * The interface Notification service.
 */
public interface NotificationService {
    /**
     * Gets all notification.
     *
     * @param user the user
     * @return the all notification
     */
    void getAllNotification(final User user);

    /**
     * Send notification notification.
     *
     * @param notification the notification
     * @return the notification
     */
    Notification sendNotification(final Notification notification);

    /**
     * Create notification notification.
     *
     * @param notification    the notification
     * @param participantList the participant list
     * @return the notification
     */
    void createNotification(final Notification notification, final List<User> participantList);
}
