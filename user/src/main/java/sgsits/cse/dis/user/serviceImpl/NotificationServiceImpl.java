package sgsits.cse.dis.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import sgsits.cse.dis.user.model.Notification;
import sgsits.cse.dis.user.model.User;
import sgsits.cse.dis.user.repo.NotificationParticipantRepository;
import sgsits.cse.dis.user.repo.NotificationRepository;
import sgsits.cse.dis.user.service.NotificationService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Notification service.
 */
public class NotificationServiceImpl implements NotificationService {

    /**
     * The Notification repository.
     */
    private final NotificationRepository notificationRepository;
    /**
     * The Notification participant repository.
     */
    private final NotificationParticipantRepository notificationParticipantRepository;

    /**
     * Instantiates a new Notification service.
     *
     * @param notificationRepository            the notification repository
     * @param notificationParticipantRepository the notification participant repository
     */
    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository, NotificationParticipantRepository notificationParticipantRepository) {
        this.notificationRepository = notificationRepository;
        this.notificationParticipantRepository = notificationParticipantRepository;
    }

    @Override
    public List<Notification> getAllNotification(final User user) {
        return notificationParticipantRepository.findAllByUser(user)
                .stream()
                .map(notificationParticipant -> notificationParticipant.getNotification())
                .collect(Collectors.toList());
    }
}
