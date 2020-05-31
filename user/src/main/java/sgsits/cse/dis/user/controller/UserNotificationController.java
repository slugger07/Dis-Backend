package sgsits.cse.dis.user.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import sgsits.cse.dis.user.dto.NotificationDto;
import sgsits.cse.dis.user.dto.SendNotificationRequestDto;
import sgsits.cse.dis.user.jwt.JwtResolver;
import sgsits.cse.dis.user.service.NotificationService;

import java.util.List;

/**
 * The type User notification controller.
 */
@Api(value = "User Notification Controller")
@RestController
@Controller
@RequestMapping(path = "/userNotificationController")
public class UserNotificationController {

    /**
     * The Notification service.
     */
    private final NotificationService notificationService;

    /**
     * The constant LOG.
     */
    public static Logger LOG = LoggerFactory.getLogger(UserNotificationController.class);

    /**
     * Instantiates a new User notification controller.
     *
     * @param notificationService the notification service
     */
    @Autowired
    public UserNotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

//    /**
//     * Gets all notifications.
//     *
//     * @param username the username
//     * @return the all notifications
//     */
//    @GetMapping(value = "/getAllNotification/{username}")
//    public List<NotificationDto> getAllNotifications(@PathVariable("username") final String username) {
//        return notificationService.getAllNotification(username);
//    }

    /**
     * Gets user name.
     *
     * @param authHeader the auth header
     * @return the user name
     */
    @GetMapping(value = "/getAllNotifications")
    public List<NotificationDto> getUserName(@RequestHeader("Authorization") final String authHeader) { //HttpServletRequest request) {
        final String username = JwtResolver.getUsernameFromAuthHead(authHeader);//request.getHeader("Authorization"));
        return notificationService.getAllNotification(username);
    }

    /**
     * Mark as read.
     *
     * @param notificationId the notification id
     * @param authHeader     the auth header
     */
    @GetMapping(value = "/markAsRead/{notificationId}")
    public void markAsRead(@PathVariable("notificationId") final String notificationId, @RequestHeader("Authorization") final String authHeader) {
        final String username = JwtResolver.getUsernameFromAuthHead(authHeader);
        notificationService.markAsRead(notificationId, username);
    }

    /**
     * Mark  all as read.
     *
     * @param authHeader the auth header
     */
    @GetMapping(value = "/markAllAsRead")
    public void markAllAsRead(@RequestHeader("Authorization") final String authHeader) {
        final String username = JwtResolver.getUsernameFromAuthHead(authHeader);
        notificationService.markAllAsRead(username);
    }

    /**
     * Send notification to all.
     *
     * @param notificationRequest the notification request
     */
    @PostMapping(value = "/sendNotificationToAll")
    public void sendNotificationToAll(@RequestBody final SendNotificationRequestDto notificationRequest) {
        notificationService.sendNotificationToAll(notificationRequest.getNotification());
    }

    /**
     * Send notification to participants.
     *
     * @param notificationRequest the notification request
     */
    @PostMapping(value = "/sendNotificationToParticipants")
    public void sendNotificationToParticipants(@RequestBody final SendNotificationRequestDto notificationRequest) {
        notificationService.sendNotificationToParticipants(notificationRequest.getNotification(),
                notificationRequest.getUsernameList());
    }

    /**
     * Send notification to all except.
     *
     * @param notificationRequest the notification request
     */
    @PostMapping(value = "/sendNotificationByTypeExceptGivenUsers")
    public void sendNotificationToAllExcept(@RequestBody final SendNotificationRequestDto notificationRequest) {
        notificationService.sendNotificationByTypeExceptGivenUsers(notificationRequest.getNotification(),
                notificationRequest.getTypeList(),
                notificationRequest.getUsernameList());
    }

    /**
     * Send notification to all except.
     *
     * @param notificationRequest the notification request
     */
    @PostMapping(value = "/sendNotificationByType")
    public void sendNotificationByType(@RequestBody final SendNotificationRequestDto notificationRequest) {
        notificationService.sendNotificationByType(notificationRequest.getNotification(),
                notificationRequest.getTypeList());
    }
}