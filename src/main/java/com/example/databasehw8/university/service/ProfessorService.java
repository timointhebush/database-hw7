package com.example.databasehw8.university.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.databasehw8.university.domain.Professor;
import com.example.databasehw8.university.repository.ProfessorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfessorService {
	private ProfessorRepository professorRepository;

	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	public long count() {
		return professorRepository.count();
	}
}
