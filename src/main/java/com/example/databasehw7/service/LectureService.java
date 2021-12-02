package com.example.databasehw7.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.databasehw7.domain.Lecture;
import com.example.databasehw7.repository.LectureRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LectureService {
	private LectureRepository lectureRepository;

	public List<Lecture> findAll() {
		return lectureRepository.findAll();
	}

	public long count() {
		return lectureRepository.count();
	}
}
