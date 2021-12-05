package com.example.databasehw8.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.databasehw8.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
