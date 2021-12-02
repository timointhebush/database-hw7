package com.example.databasehw7.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.databasehw7.domain.Course;
import com.example.databasehw7.repository.CourseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService {
	private CourseRepository courseRepository;

	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	public long count() {
		return courseRepository.count();
	}
}
