package sgsits.cse.dis.user.service;

import sgsits.cse.dis.user.model.Notification;
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
    List<Notification> getAllNotification(final User user);

    /**
     * Send notification notification.
     *
     * @param notification the notification
     * @param participants the participants
     * @return the notification
     */
    Notification sendNotification(final Notification notification, final List<User> participants);
}
