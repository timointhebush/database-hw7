package com.example.databasehw8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw8.domain.Lecture;
import com.example.databasehw8.domain.LectureId;

public interface LectureRepository extends JpaRepository<Lecture, LectureId> {
}
