package com.example.databasehw7.controller;

import com.example.databasehw7.domain.Employee;
import com.example.databasehw7.domain.Student;
import com.example.databasehw7.service.EmployeeService;
import com.example.databasehw7.service.StudentService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AllArgsConstructor
@RestController
public class DatabaseController {
    private EmployeeService employeeService;
    private StudentService studentService;

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

    // @GetMapping(value = "/student")
    // public ModelAndView stu() {
    //     ModelAndView modelAndView = new ModelAndView("selectTest");
    //     List<Student> students = studentService.findAll();
    //     modelAndView.addObject("students", students);
    //     return modelAndView;
    // }

    @GetMapping(value = "/student/form")
    public ModelAndView FormStudent() {
        ModelAndView modelAndView = new ModelAndView("insertTestForm");
        return modelAndView;
    }

    @PostMapping(value = "/student")
    public ModelAndView InsertStudent(Student student) {
        ModelAndView modelAndView = new ModelAndView("insertTest");
        Student savedStudent = studentService.save(student);
        modelAndView.addObject("student", savedStudent);
        return modelAndView;
    }
}
