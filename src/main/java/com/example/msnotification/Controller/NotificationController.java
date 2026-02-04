package com.example.msnotification.Controller;

import com.example.msnotification.Entity.Notification;
import com.example.msnotification.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("notification")
@CrossOrigin( "*")
public class NotificationController {
   @Autowired
   NotificationService notificationService;

    @PostMapping("add")
    public Notification addNotification(@RequestBody Notification notification) {
        return notificationService.ajouterNotification(notification);
    }

    @GetMapping("getnotifications")
    public List<Notification> getNotifications() {
        return notificationService.findAllNotifications();
    }

    @GetMapping("get/{id}")
    public Notification getNotification(@PathVariable("id") Long notification_id) {
        return notificationService.findById(notification_id);
    }

    @PutMapping("update")
    public Notification updateNotification(@RequestBody Notification notification) {
        return notificationService.modifierNotification(notification);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") Long notification_id) {
        notificationService.deleteNotificationById(notification_id);
    }
}
