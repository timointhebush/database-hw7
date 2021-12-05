package com.example.databasehw8.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.databasehw8.domain.Enroll;
import com.example.databasehw8.projection.SumCreditMeanExam;
import com.example.databasehw8.service.EnrollService;

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

	/**
	 * 1.-d) 과목별로 최고, 최저 점수를 획득 한 학생의 정보 확인
	 * @return
	 */
	@GetMapping(value = "/enroll/minmax")
	public ModelAndView showMinMaxExam() {
		List<Enroll> enrollList = enrollService.searchByMinMaxExamStudent();
		ModelAndView modelAndView = new ModelAndView("1dMinMaxExam");
		modelAndView.addObject("enrollList", enrollList);
		return modelAndView;
	}

	/**
	 * 1 -e) 학생 별로 수강한 교과목의 총 학점과, 시험 점수의 평균 확인
	 * @return
	 */
	@GetMapping(value = "/enroll/sumcredit-avgexam")
	public ModelAndView showSumCreditAvgExam() {
		List<SumCreditMeanExam> sumCreditMeanExams = enrollService.searchBySumCreditMeanExam();
		ModelAndView modelAndView = new ModelAndView("1eSumCreditMeanExam");
		modelAndView.addObject("sumCreditMeanExams", sumCreditMeanExams);
		return modelAndView;
	}
}
