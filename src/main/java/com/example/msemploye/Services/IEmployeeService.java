package com.example.msemploye.Services;

import com.example.msemploye.Entities.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee create(Employee employee);

    Employee get(Long id);

    List<Employee> getAll();

    Employee update(Long id, Employee employee);

    void delete(Long id);

    Employee getEmployeeById(Long employeeId);
}
