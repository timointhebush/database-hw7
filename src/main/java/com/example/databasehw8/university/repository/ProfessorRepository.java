package com.example.databasehw8.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw8.university.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
