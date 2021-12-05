package com.example.databasehw8;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.databasehw8.university.domain.Course;
import com.example.databasehw8.university.domain.Enroll;
import com.example.databasehw8.university.domain.EnrollId;
import com.example.databasehw8.university.domain.Student;
import com.example.databasehw8.university.projection.MeanExamByCno;
import com.example.databasehw8.university.projection.SumCreditMeanExam;
import com.example.databasehw8.university.repository.CourseRepository;
import com.example.databasehw8.university.repository.EnrollRepository;
import com.example.databasehw8.university.repository.StudentRepository;


@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EnrollTest {
	@Autowired
	private EnrollRepository enrollRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void 틀린성적수정Test() {
		Student student = studentRepository.getById(2305);
		Course course = courseRepository.getById("CE007");
		EnrollId enrollId = new EnrollId(student, course);
		Enroll enroll = enrollRepository.getById(enrollId);
		System.out.println(enroll.getGrade());
		enroll.correctGrade();
		Enroll afterEnroll = enrollRepository.getById(enrollId);
		Assertions.assertEquals("B", afterEnroll.getGrade());
	}

	@Test
	public void group_byTest() {
		List<SumCreditMeanExam> enrollList = enrollRepository.findStudentSumCreditMeanExam();
		System.out.println(enrollList.toString());
	}

	@Test
	public void 과제1fTest() {
		List<MeanExamByCno> meanExamByCnos = enrollRepository.findMeanExamByCno();
		System.out.println(meanExamByCnos.toString());
	}
}
