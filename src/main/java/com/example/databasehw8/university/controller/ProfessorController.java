package com.example.databasehw8.university.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.databasehw8.university.domain.Professor;
import com.example.databasehw8.university.service.ProfessorService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProfessorController {
	private ProfessorService professorService;

	/**
	 * 1-a) Professor Table에 존재하는 Data, Tuple 총 갯수 확인.
	 * @return
	 */
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
