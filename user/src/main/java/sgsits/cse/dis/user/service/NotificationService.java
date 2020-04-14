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
}
