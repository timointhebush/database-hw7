package com.example.databasehw7.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.databasehw7.domain.Enroll;
import com.example.databasehw7.service.EnrollService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EnrollController {
	private EnrollService enrollService;

	@GetMapping(value = "/enroll")
	public ModelAndView showDataAndCount() {
		List<Enroll> enrollList = enrollService.findAll();
		long enrollNum = enrollService.count();
		ModelAndView modelAndView = new ModelAndView("1a/enroll");
		modelAndView.addObject("enrollList", enrollList);
		modelAndView.addObject("enrollNum", enrollNum);
		return modelAndView;
	}

	@GetMapping(value = "/enroll/wrong")
	public ModelAndView wrongGraded() {
		List<Enroll> wrongGradedEnrollList = enrollService.findWrongGraded();
		ModelAndView modelAndView = new ModelAndView("1cWrongGraded");
		modelAndView.addObject("wrongGradedEnrollList", wrongGradedEnrollList);
		return modelAndView;
	}

	@GetMapping(value = "/enroll/wrong/correct")
	public ModelAndView correctGrade(@RequestParam Integer sno, @RequestParam String cno) {
		enrollService.correctWrongGrade(sno, cno);
		return wrongGraded();
	}
}
