package com.example.databasehw7.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.databasehw7.domain.Enroll;
import com.example.databasehw7.repository.EnrollRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnrollService {
	private EnrollRepository enrollRepository;

	public List<Enroll> findAll() {
		return enrollRepository.findAll();
	}

	public long count() {
		return enrollRepository.count();
	}
}
