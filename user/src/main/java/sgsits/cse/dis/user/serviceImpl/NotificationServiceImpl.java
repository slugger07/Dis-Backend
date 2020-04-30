package sgsits.cse.dis.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import sgsits.cse.dis.user.model.Notification;
import sgsits.cse.dis.user.model.NotificationParticipant;
import sgsits.cse.dis.user.model.User;
import sgsits.cse.dis.user.repo.NotificationParticipantRepository;
import sgsits.cse.dis.user.repo.NotificationRepository;
import sgsits.cse.dis.user.service.NotificationService;

import java.util.List;
import java.util.stream.Collectors;

import static sgsits.cse.dis.user.config.WebSocketConfig.notificationEndpoint;
import static sgsits.cse.dis.user.config.WebSocketConfig.topicName;

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
    public void getAllNotification(final User user) {
         notificationParticipantRepository.findAllByUser(user)
                .stream()
                .map(NotificationParticipant::getNotification)
                .forEach(this::sendNotification);
    }

    @Override
    //@MessageMapping("${dis.notification.notificationEndpoint}")
    @SendTo("${dis.notification.notificationBucket}")
    public Notification sendNotification(Notification notification) {
        // TODO: 30-04-2020 Check if the annotation actually sends the notification to the websocket
        return notification;
    }

    @Override
    public void createNotification(Notification notification, List<User> participantList) {
        final Notification savedNotification = notificationRepository.save(notification);
        participantList.forEach(participant -> saveParticipant(savedNotification, participant));
        sendNotification(savedNotification);
    }

    /**
     * Persist notification.
     *
     * @param notification the notification
     * @param participant  the participant
     */
    private void saveParticipant(Notification notification, User participant) {
        final NotificationParticipant participation = new NotificationParticipant();
        participation.setNotification(notification);
        participation.setUser(participant);
        participation.setReadStatus(false);
        notificationParticipantRepository.save(participation);
    }
}
