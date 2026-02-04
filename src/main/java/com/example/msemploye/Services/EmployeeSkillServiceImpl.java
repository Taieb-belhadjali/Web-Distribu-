package com.example.msemploye.Services;

import com.example.msemploye.Entities.Employee;
import com.example.msemploye.Entities.EmployeeSkill;
import com.example.msemploye.Repository.EmployeeRepository;
import com.example.msemploye.Repository.EmployeeSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillServiceImpl implements IEmployeeSkillService {

    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeSkill addSkill(EmployeeSkill skill) {
        // Récupérer l'employé depuis la base
        Employee emp = employeeRepository.findById(skill.getEmployee().getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        skill.setEmployee(emp);
        return employeeSkillRepository.save(skill);
    }

    @Override
    public List<EmployeeSkill> getSkills(Long employeeId) {
        return employeeSkillRepository.findByEmployeeId(employeeId);
    }

    @Override
    public void deleteSkill(Long employeeSkillId) {
        employeeSkillRepository.deleteById(employeeSkillId);
    }
}
