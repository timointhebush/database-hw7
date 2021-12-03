package com.example.databasehw7.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.databasehw7.domain.Student;
import com.example.databasehw7.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {
	private StudentRepository studentRepository;

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public long count() {
		return studentRepository.count();
	}

	public Student save(Student student) {
		studentRepository.save(student);
		return student;
	}

	public Student getBySno(Integer sno) {
		return studentRepository.getById(sno);
	}
}
