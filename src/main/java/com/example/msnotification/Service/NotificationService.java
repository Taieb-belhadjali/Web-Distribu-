package com.example.msnotification.Service;

import com.example.msnotification.Entity.Notification;

import java.util.List;

public interface NotificationService {
    Notification ajouterNotification(Notification notification);
    Notification modifierNotification(Notification notification);
    void deleteNotificationById(Long notification_id);
    Notification findById(Long notification_id);
    List<Notification> findAllNotifications();
}
