package com.example.databasehw8.university.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.databasehw8.university.domain.Course;
import com.example.databasehw8.university.domain.Enroll;
import com.example.databasehw8.university.projection.CntSnoByGrade;
import com.example.databasehw8.university.projection.MeanExamByCno;
import com.example.databasehw8.university.projection.SumCreditMeanExam;
import com.example.databasehw8.university.service.CourseService;
import com.example.databasehw8.university.service.EnrollService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EnrollController {
	private EnrollService enrollService;
	private CourseService courseService;

	/**
	 * 1-a) Enroll Table에 존재하는 Data, Tuple 총 갯수 확인.
	 * @return
	 */
	@GetMapping(value = "/enroll")
	public ModelAndView showDataAndCount() {
		List<Enroll> enrollList = enrollService.findAll();
		long enrollNum = enrollService.count();
		ModelAndView modelAndView = new ModelAndView("1a/enroll");
		modelAndView.addObject("enrollList", enrollList);
		modelAndView.addObject("enrollNum", enrollNum);
		return modelAndView;
	}

	/**
	 * 1-c) 시험 점수에 대한 학점이 잘못 기재되어 있는 학생 확인
	 * @return
	 */
	@GetMapping(value = "/enroll/wrong")
	public ModelAndView wrongGraded() {
		List<Enroll> wrongGradedEnrollList = enrollService.findWrongGraded();
		ModelAndView modelAndView = new ModelAndView("1cWrongGraded");
		modelAndView.addObject("wrongGradedEnrollList", wrongGradedEnrollList);
		return modelAndView;
	}

	/**
	 * 1-c) 잘못 기재 된 학생의 학점을 수정
	 * @param sno
	 * @param cno
	 * @return
	 */
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

	/**
	 * 1 - f) 과목 별 전체 평균 점수 확인
	 * @return
	 */
	@GetMapping(value = "/enroll/avg-exam")
	public ModelAndView showMeanExamByCno() {
		List<MeanExamByCno> meanExamByCnos = enrollService.searchMeanExamByCno();
		ModelAndView modelAndView = new ModelAndView("1fMeanExamByCno");
		modelAndView.addObject("meanExamByCnos", meanExamByCnos);
		return modelAndView;
	}

	/**
	 * 1- f) 해당 과목 성적 별 학생 수 확인
	 * @param cno 확인하고자 하는 과목 번호
	 * @return
	 */
	@GetMapping(value = "/enroll/avg-exam/grade")
	public ModelAndView showCntStudentByGrade(@RequestParam String cno) {
		List<CntSnoByGrade> cntSnoByGrades = enrollService.searchCntSnoByGrade(cno);
		Course course = courseService.getById(cno);
		ModelAndView modelAndView = new ModelAndView("1fCntSnoByGrade");
		modelAndView.addObject("cname", course.getCname());
		modelAndView.addObject("cntSnoByGrades", cntSnoByGrades);
		return modelAndView;
	}
}
