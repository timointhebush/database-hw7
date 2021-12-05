package com.example.databasehw8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw8.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
