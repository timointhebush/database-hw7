package com.example.databasehw7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw7.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
