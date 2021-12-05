package com.example.databasehw8.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw8.university.domain.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
}
