package com.example.databasehw8.service;

import com.example.databasehw8.domain.Employee;
import com.example.databasehw8.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

}
