package com.example.databasehw8.university.service;

import java.util.List;

import com.example.databasehw8.university.projection.CntSnoByDept;
import com.example.databasehw8.university.projection.CntSnoByYear;
import org.springframework.stereotype.Service;

import com.example.databasehw8.university.domain.Student;
import com.example.databasehw8.university.repository.StudentRepository;

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

	public List<CntSnoByYear> getCntSnoByYear() {
		return studentRepository.getCntSnoByYear();
	};

	public List<CntSnoByDept> getCntSnoByDept() {
		return studentRepository.getCntSnoByDept();
	};
}
