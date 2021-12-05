package com.example.databasehw8.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.databasehw8.domain.Lecture;
import com.example.databasehw8.service.LectureService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LectureController {
	private LectureService lectureService;

	@GetMapping(value = "/lecture")
	public ModelAndView showDataAndCount() {
		List<Lecture> lectureList = lectureService.findAll();
		long lectureNum = lectureService.count();
		ModelAndView modelAndView = new ModelAndView("1a/lecture");
		modelAndView.addObject("lectureList", lectureList);
		modelAndView.addObject("lectureNum", lectureNum);
		return modelAndView;
	}
}
