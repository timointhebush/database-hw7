package com.example.databasehw7.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
