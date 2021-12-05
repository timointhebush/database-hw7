package com.example.databasehw8.university.controller;

import java.util.List;

import com.example.databasehw8.university.projection.CntSnoByDept;
import com.example.databasehw8.university.projection.CntSnoByYear;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.databasehw8.university.domain.Enroll;
import com.example.databasehw8.university.domain.Student;
import com.example.databasehw8.university.service.EnrollService;
import com.example.databasehw8.university.service.StudentService;

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

	/**
	 * 1-h) 학년 별 총 학생 수 확인
	 * @return
	 */
	@GetMapping(value = "/student/year")
	public ModelAndView getCntSnoByYear() {
		List<CntSnoByYear> cntSnoByYears = studentService.getCntSnoByYear();
		ModelAndView modelAndView = new ModelAndView("1hCntSnoByYear");
		modelAndView.addObject("cntSnoByYears", cntSnoByYears);
		return modelAndView;
	}

	/**
	 * 1-h) 전공 별 총 학생 수 확인
	 * @return
	 */
	@GetMapping(value = "/student/dept")
	public ModelAndView getCntSnoByDept() {
		List<CntSnoByDept> cntSnoByDepts = studentService.getCntSnoByDept();
		ModelAndView modelAndView = new ModelAndView("1hCntSnoByDept");
		modelAndView.addObject("cntSnoByDepts", cntSnoByDepts);
		return modelAndView;
	}
}
