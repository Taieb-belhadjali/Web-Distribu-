package com.example.msemploye.Entities;

import com.example.msemploye.Enum.SkillType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    @ManyToOne
    private Employee employee;

    @Enumerated(EnumType.STRING)
    private SkillType level;
}
