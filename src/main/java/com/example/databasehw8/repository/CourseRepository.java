package com.example.databasehw8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw8.domain.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
}
