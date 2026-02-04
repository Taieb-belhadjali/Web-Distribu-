package com.example.msemploye.Services;

import com.example.msemploye.Entities.Employee;
import com.example.msemploye.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee get(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Long id, Employee updatedEmployee) {
        Employee emp = get(id);
        emp.setJobPosition(updatedEmployee.getJobPosition());
        emp.setExperience(updatedEmployee.getExperience());
        return employeeRepository.save(emp);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return null;
    }
}