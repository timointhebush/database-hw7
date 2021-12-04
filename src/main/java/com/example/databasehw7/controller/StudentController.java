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
	public ModelAndView studentsCourse(@RequestParam Integer sno) {
		Student student = studentService.getBySno(sno);
		List<Enroll> enrollList = enrollService.findByStudent(student);
		ModelAndView modelAndView = new ModelAndView("1bStudentEnrollCourse");
		modelAndView.addObject("student", student);
		modelAndView.addObject("enrollList", enrollList);
		return modelAndView;
	}

	@GetMapping(value = "/student/enroll/search/cname")
	public ModelAndView searchCname(@RequestParam Integer sno, @RequestParam String cname) {
		List<Enroll> enrollList = enrollService.searchBySnoAndCname(sno, cname);
		return searchReturnMaV(sno, enrollList);
	}

	@GetMapping(value = "/student/enroll/search/credit")
	public ModelAndView searchCredit(@RequestParam Integer sno, @RequestParam Integer credit) {
		List<Enroll> enrollList = enrollService.searchBySnoAndCredit(sno, credit);
		return searchReturnMaV(sno, enrollList);
	}

	@GetMapping(value = "/student/enroll/search/exam")
	public ModelAndView searchExam(@RequestParam Integer sno, @RequestParam Integer exam) {
		List<Enroll> enrollList = enrollService.searchBySnoAndExam(sno, exam);
		return searchReturnMaV(sno, enrollList);
	}

	public ModelAndView searchReturnMaV(Integer sno, List<Enroll> enrollList) {
		Student student = studentService.getBySno(sno);
		ModelAndView modelAndView = new ModelAndView("1bStudentEnrollCourse");
		modelAndView.addObject("student", student);
		modelAndView.addObject("enrollList", enrollList);
		return modelAndView;
	}
}
