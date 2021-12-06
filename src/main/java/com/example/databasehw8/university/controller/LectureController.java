package com.example.databasehw8.university.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.databasehw8.university.domain.Lecture;
import com.example.databasehw8.university.projection.CntCnoByMajor;
import com.example.databasehw8.university.service.LectureService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LectureController {
	private LectureService lectureService;

	/**
	 * 1-a) Lecture Table에 존재하는 Data, Tuple 총 갯수 확인.
	 * @return
	 */
	@GetMapping(value = "/lecture")
	public ModelAndView showDataAndCount() {
		List<Lecture> lectureList = lectureService.findAll();
		long lectureNum = lectureService.count();
		ModelAndView modelAndView = new ModelAndView("1a/lecture");
		modelAndView.addObject("lectureList", lectureList);
		modelAndView.addObject("lectureNum", lectureNum);
		return modelAndView;
	}

	/**
	 * 1-g) 학과 별로 개설된 강좌 수 확인
	 * @return
	 */
	@GetMapping(value = "/lecture/cnt")
	public ModelAndView showCntCnoByMajor() {
		List<CntCnoByMajor> cntCnoByMajors = lectureService.findCntCnoByMajor();
		ModelAndView modelAndView = new ModelAndView("1gCntCnoByMajor");
		modelAndView.addObject("cntCnoByMajors", cntCnoByMajors);
		return modelAndView;
	}
}
