package com.example.databasehw7.controller;

import com.example.databasehw7.domain.Employee;
import com.example.databasehw7.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@RestController
public class DatabaseController {
    private EmployeeService employeeService;

    @GetMapping(value = "/home")
    public String home() {
        return "Hello World";
    }

    @GetMapping(value = "/test")
    public ModelAndView viewTest() {
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("name", "world");
        return modelAndView;
    }

    @GetMapping(value = "/emp")
    public ModelAndView emp() {
        ModelAndView modelAndView = new ModelAndView("emp");
        List<Employee> employees = employeeService.findAll();
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
}
