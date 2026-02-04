package com.example.msemploye.Controllers;

import com.example.msemploye.Entities.Employee;
import com.example.msemploye.Entities.Employee;
import com.example.msemploye.Services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    // Créer un employé
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    // Récupérer un employé par ID
    @GetMapping("/{id}")
    public Employee get(@PathVariable Long id) {
        return employeeService.get(id);
    }

    // Récupérer tous les employés
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    // Mettre à jour un employé
    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    // Supprimer un employé
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
