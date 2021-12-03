package com.example.databasehw7.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.databasehw7.domain.Enroll;
import com.example.databasehw7.domain.Student;
import com.example.databasehw7.service.EnrollService;
import com.example.databasehw7.service.StudentService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudentController {
	private StudentService studentService;
	private EnrollService enrollService;

	@GetMapping(value = "/student")
	public ModelAndView showDataAndCount() {
		List<Student> studentList = studentService.findAll();
		long studentNum = studentService.count();
		ModelAndView modelAndView = new ModelAndView("1a/student");
		modelAndView.addObject("studentList", studentList);
		modelAndView.addObject("studentNum", studentNum);
		return modelAndView;
	}

	@GetMapping(value = "/student/enroll")
	public ModelAndView ss(@RequestParam Integer sno) {
		Student student = studentService.getBySno(sno);
		List<Enroll> enrollList = enrollService.findByStudent(student);
		ModelAndView modelAndView = new ModelAndView("1bStudentEnrollCourse");
		modelAndView.addObject("student", student);
		modelAndView.addObject("enrollList", enrollList);
		return modelAndView;
	}
}
