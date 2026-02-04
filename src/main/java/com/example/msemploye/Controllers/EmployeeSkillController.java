package com.example.msemploye.Controllers;

import com.example.msemploye.Entities.Employee;
import com.example.msemploye.Entities.EmployeeSkill;
import com.example.msemploye.Enum.SkillType;
import com.example.msemploye.Services.IEmployeeService;
import com.example.msemploye.Services.IEmployeeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees/{employeeId}/skills")
public class EmployeeSkillController {

    @Autowired
    private IEmployeeSkillService employeeSkillService;

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> addSkill(
            @PathVariable Long employeeId,
            @RequestBody Map<String, String> request
    ) {
        try {
            Employee employee = employeeService.get(employeeId);
            if (employee == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Employee with id " + employeeId + " not found");
            }

            String levelStr = request.get("level");
            if (levelStr == null) {
                return ResponseEntity.badRequest().body("Level is required");
            }

            SkillType level;
            try {
                level = SkillType.valueOf(levelStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest()
                        .body("Invalid level. Allowed values: LOW, MEDIUM, HIGH");
            }

            EmployeeSkill skill = new EmployeeSkill();
            skill.setEmployee(employee);
            skill.setLevel(level);

            EmployeeSkill savedSkill = employeeSkillService.addSkill(skill);
            return ResponseEntity.ok(savedSkill);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding skill: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<EmployeeSkill>> getSkills(@PathVariable Long employeeId) {
        Employee employee = employeeService.get(employeeId);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(employeeSkillService.getSkills(employeeId));
    }

    @DeleteMapping("/{employeeSkillId}")
    public ResponseEntity<?> deleteSkill(@PathVariable Long employeeSkillId) {
        try {
            employeeSkillService.deleteSkill(employeeSkillId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting skill: " + e.getMessage());
        }
    }
}
