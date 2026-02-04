package com.example.msemploye.Services;

import com.example.msemploye.Entities.EmployeeSkill;
import java.util.List;

public interface IEmployeeSkillService {
    EmployeeSkill addSkill(EmployeeSkill skill);
    List<EmployeeSkill> getSkills(Long employeeId);
    void deleteSkill(Long employeeSkillId);
}
