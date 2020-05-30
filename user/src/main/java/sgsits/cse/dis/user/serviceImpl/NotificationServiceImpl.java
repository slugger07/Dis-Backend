package sgsits.cse.dis.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.dto.NotificationDto;
import sgsits.cse.dis.user.model.Notification;
import sgsits.cse.dis.user.model.NotificationParticipant;
import sgsits.cse.dis.user.model.User;
import sgsits.cse.dis.user.repo.NotificationParticipantRepository;
import sgsits.cse.dis.user.repo.NotificationRepository;
import sgsits.cse.dis.user.repo.UserRepository;
import sgsits.cse.dis.user.service.NotificationService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Notification service.
 */
@Service
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
     * The User repository.
     */
    private final UserRepository userRepository;

    /**
     * The Template.
     */
    private final SimpMessagingTemplate template;

    /**
     * The constant notificationBucket.
     */
    @Value("${dis.notification.notificationBucket}")
    public static String notificationBucket;

    /**
     * Instantiates a new Notification service.
     *
     * @param notificationRepository            the notification repository
     * @param notificationParticipantRepository the notification participant repository
     * @param userRepository                    the user repository
     * @param template                          the template
     */
    @Autowired
    public NotificationServiceImpl(@Qualifier("notificationServiceRepository") NotificationRepository notificationRepository,
                                   @Qualifier("notificationParticipantRepository") NotificationParticipantRepository notificationParticipantRepository,
                                   @Qualifier("userServiceRepository") UserRepository userRepository,
                                   SimpMessagingTemplate template) {
        this.notificationRepository = notificationRepository;
        this.notificationParticipantRepository = notificationParticipantRepository;
        this.userRepository = userRepository;
        this.template = template;
    }

    @Override
    public List<NotificationDto> getAllNotification(final String username) throws EntityNotFoundException {
        final User user = userRepository.findByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
        return notificationParticipantRepository.findAllByUser(user)
                .stream()
                .map(this::notificationDtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public void sendNotificationToAll(final Notification notification) {
        final Notification savedNotification = notificationRepository.save(notification);
        userRepository.getAllUsers().forEach(user -> saveParticipant(savedNotification, user));
        //sendToAllWebsocket(savedNotification);
    }

    @Override
    public void sendNotificationToParticipants(final Notification notification, final List<String> usernameList) {
        final Notification savedNotification = notificationRepository.save(notification);
        final List<User> participants = userRepository.findAllByUsernameIn(usernameList);
        participants.forEach(participant -> saveParticipant(savedNotification, participant));
        //sendToUserWebsocket(savedNotification, participants);
    }

    @Override
    public void sendNotificationByTypeExceptGivenUsers(final Notification notification, final List<String> typeList, final List<String> usernameList) {
        final Notification savedNotification = notificationRepository.save(notification);
        final List<User> participants = userRepository.findAllByUserTypeInAndUsernameNotIn(typeList, usernameList);
        participants.forEach(participant -> saveParticipant(savedNotification, participant));
        //sendToUserWebsocket(savedNotification, participants);
    }

    @Override
    public void sendNotificationByType(final Notification notification, final List<String> typeList) {
        final Notification savedNotification = notificationRepository.save(notification);
        final List<User> participants = userRepository.findAllByUserTypeIn(typeList);
        participants.forEach(participant -> saveParticipant(savedNotification, participant));
    }

    @Override
    public void markAsRead(final String notificationId, final String username) {
        final User user = userRepository.findByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
        notificationParticipantRepository.modifyReadStatus(notificationId, user.getId(), true);
    }
    
    @Override
    public void markAllAsRead(final String username) {
        final User user = userRepository.findByUsername(username)
                .orElseThrow(EntityNotFoundException::new);
        notificationParticipantRepository.modifyReadStatusOfAll(user.getId(), true);
    }
    

//    /**
//     * Send to all websocket notification.
//     *
//     * @param notification the notification
//     * @return the notification
//     */
//    @SendTo("${dis.notification.notificationBucket}")
//    private Notification sendToAllWebsocket(Notification notification) {
//        // TODO: 30-04-2020 Check if the annotation actually sends the notification to the websocket
//        return notification;
//    }
//
//    /**
//     * Send to user websocket notification.
//     *
//     * @param notification    the notification
//     * @param participantList the participant list
//     * @return the notification
//     */
//    private void sendToUserWebsocket(Notification notification, List<User> participantList) {
//        // TODO: 01-05-2020 Write logic to multicast, check if return type will be void or not
//        participantList.forEach(participant -> template.convertAndSendToUser(participant.getUsername(),
//                notificationBucket, notification));
//    }

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

    /**
     * Notification dto mapper notification dto.
     *
     * @param participant the participant
     * @return the notification dto
     */
    private NotificationDto notificationDtoMapper(NotificationParticipant participant) {
        return new NotificationDto(participant.getNotification().getId(),
                participant.getNotification().getHeading(),
                participant.getNotification().getDescription(),
                participant.getNotification().getLink(),
                participant.getReadStatus(),
        		participant.getNotification().getCreatedDate());
    }
}
