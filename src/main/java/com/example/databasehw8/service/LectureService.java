package com.example.databasehw8.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.databasehw8.domain.Lecture;
import com.example.databasehw8.projection.CntCnoByMajor;
import com.example.databasehw8.repository.LectureRepository;

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

	public List<CntCnoByMajor> findCntCnoByMajor() {
		return lectureRepository.findCntLec();
	}
}
