package com.example.databasehw7.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.databasehw7.domain.Enroll;
import com.example.databasehw7.domain.EnrollId;
import com.example.databasehw7.domain.Student;
import com.example.databasehw7.repository.CourseRepository;
import com.example.databasehw7.repository.EnrollRepository;
import com.example.databasehw7.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class EnrollService {
	private EnrollRepository enrollRepository;
	private StudentRepository studentRepository;
	private CourseRepository courseRepository;

	public List<Enroll> findAll() {
		return enrollRepository.findAll();
	}

	public long count() {
		return enrollRepository.count();
	}

	public List<Enroll> findWrongGraded() {
		List<Enroll> wrongGradedEnrollList = new ArrayList<>();
		wrongGradedEnrollList.addAll(enrollRepository.findWrongGraded("A", 90, 100));
		wrongGradedEnrollList.addAll(enrollRepository.findWrongGraded("B", 80, 89));
		wrongGradedEnrollList.addAll(enrollRepository.findWrongGraded("C", 70, 79));
		wrongGradedEnrollList.addAll(enrollRepository.findWrongGraded("D", 60, 69));
		wrongGradedEnrollList.addAll(enrollRepository.findWrongGraded("F", 0, 60));
		return wrongGradedEnrollList;
	}

	@Transactional
	public void correctWrongGrade(Integer sno, String cno) {
		EnrollId enrollId = new EnrollId(
			studentRepository.getById(sno),
			courseRepository.getById(cno)
		);
		Enroll wrongEnroll = enrollRepository.getById(enrollId);
		wrongEnroll.correctGrade();
	}

	public List<Enroll> findByStudent(Student student) {
		return enrollRepository.findAllByStudent(student);
	}
}
