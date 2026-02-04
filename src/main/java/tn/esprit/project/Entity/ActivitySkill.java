package tn.esprit.project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.project.Enum.SkillLevel;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActivitySkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long skillId;

    @ManyToOne
    @JsonIgnore
    private Activity activity;

    @Enumerated(EnumType.STRING)
    private SkillLevel requiredLevel;

    private Double weight;

}
