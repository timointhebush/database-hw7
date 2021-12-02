package com.example.databasehw7.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.databasehw7.domain.Course;
import com.example.databasehw7.service.CourseService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CourseController {
	private CourseService courseService;

	@GetMapping(value = "/course")
	public ModelAndView showDataAndCount() {
		List<Course> courseList = courseService.findAll();
		long courseNum = courseService.count();
		ModelAndView modelAndView = new ModelAndView("1a/course");
		modelAndView.addObject("courseList", courseList);
		modelAndView.addObject("courseNum", courseNum);
		return modelAndView;
	}
}
