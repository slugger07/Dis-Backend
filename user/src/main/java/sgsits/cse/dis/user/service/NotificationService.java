package sgsits.cse.dis.user.service;

import sgsits.cse.dis.user.dto.NotificationDto;
import sgsits.cse.dis.user.model.Notification;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * The interface Notification service.
 */
public interface NotificationService {
    /**
     * Gets all notification.
     *
     * @param username the username
     * @return the all notification
     * @throws EntityNotFoundException the entity not found exception
     */
    List<NotificationDto> getAllNotification(final String username) throws EntityNotFoundException;

    /**
     * Send notification notification.
     *
     * @param notification the notification
     * @return the notification
     */
    void sendNotificationToAll(final Notification notification);

    /**
     * Send to participants notification.
     *
     * @param notification the notification
     * @param usernameList the username list
     * @return the notification
     */
    void sendNotificationToParticipants(final Notification notification, final List<String> usernameList);

    /**
     * Send notification to all except.
     *
     * @param notification the notification
     * @param usernameList the username list
     */
    void sendNotificationByTypeExceptGivenUsers(final Notification notification, final List<String> typeList, final List<String> usernameList);

    /**
     * Send notification by type.
     *
     * @param notification the notification
     * @param types        the types
     */
    void sendNotificationByType(final Notification notification, final List<String> types);

    /**
     * Mark as read.
     *
     * @param notificationId the notification id
     * @param username       the username
     */
    void markAsRead(final String notificationId, final String username);
    
    /**
     * Mark all as read.
     *
     * @param username the username
     */
    void markAllAsRead(final String username);
}
