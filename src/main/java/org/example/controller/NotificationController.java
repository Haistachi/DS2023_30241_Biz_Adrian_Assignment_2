package assignment1.EnergyConsum.controller;

import assignment1.EnergyConsum.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/notification")
    public Notification reciveNotification(@Payload Notification notification)
    {
        simpMessagingTemplate.convertAndSendToUser(notification.getReciverName(),"/private", notification);
        return notification;
    }

    @MessageMapping("/public-notification")
    @SendTo("/chatroom/public")
    public Notification recivePublicNotification(@Payload Notification notification)
    {
        return notification;
    }
}
