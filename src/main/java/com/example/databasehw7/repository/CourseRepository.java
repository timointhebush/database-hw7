package com.example.databasehw7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw7.domain.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
}
