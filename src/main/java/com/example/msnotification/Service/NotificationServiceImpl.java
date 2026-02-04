package com.example.msnotification.Service;

import com.example.msnotification.Entity.Notification;
import com.example.msnotification.Repository.NotificationRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    NotificationRepositry notificationRepositry;
    @Override
    public Notification ajouterNotification(Notification notification) {
        return notificationRepositry.save(notification);
    }

    @Override
    public Notification modifierNotification(Notification notification) {
        return notificationRepositry.save(notification);
    }

    @Override
    public void deleteNotificationById(Long notification_id) {
        notificationRepositry.deleteById(notification_id);

    }

    @Override
    public Notification findById(Long notification_id) {
        return notificationRepositry.findById(notification_id).orElse(null);
    }

    @Override
    public List<Notification> findAllNotifications() {
        return notificationRepositry.findAll();
    }
}
