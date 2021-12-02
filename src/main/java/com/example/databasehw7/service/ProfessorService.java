package com.example.databasehw7.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.databasehw7.domain.Professor;
import com.example.databasehw7.repository.ProfessorRepository;

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
