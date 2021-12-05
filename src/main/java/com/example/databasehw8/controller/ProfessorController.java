package com.example.databasehw8.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.databasehw8.domain.Professor;
import com.example.databasehw8.service.ProfessorService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProfessorController {
	private ProfessorService professorService;

	@GetMapping(value = "/professor")
	public ModelAndView showDataAndCount() {
		List<Professor> professorList = professorService.findAll();
		long professorNum = professorService.count();
		ModelAndView modelAndView = new ModelAndView("1a/professor");
		modelAndView.addObject("professorList", professorList);
		modelAndView.addObject("professorNum", professorNum);
		return modelAndView;
	}
}
