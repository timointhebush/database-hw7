package com.example.databasehw7.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.databasehw7.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
