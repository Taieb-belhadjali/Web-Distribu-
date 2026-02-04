package com.example.msnotification.Entity;

import com.example.msnotification.Enum.TypeNotif;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private boolean senn;
    private Long idSender;
    private Long idReciever;
    private Date dateTime;
    @Enumerated(EnumType.STRING)
    private TypeNotif type;
}
