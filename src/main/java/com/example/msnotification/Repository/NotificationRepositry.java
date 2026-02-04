package com.example.msnotification.Repository;

import com.example.msnotification.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepositry extends JpaRepository<Notification,Long> {
}
