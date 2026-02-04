package tn.esprit.project.Entity;


import jakarta.persistence.*;
import lombok.*;
import tn.esprit.project.Enum.ActivityContext;
import tn.esprit.project.Enum.ActivityStatus;
import tn.esprit.project.Enum.ActivityType;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime  endDate;
    private Boolean evoluation;
    private LocalDateTime  createdAt;
    private LocalDateTime  updateddAt;

    @Enumerated(EnumType.STRING)
    private ActivityStatus status;

    @Enumerated(EnumType.STRING)
    private ActivityContext context;

    @Enumerated(EnumType.STRING)
    private ActivityType type;
}
