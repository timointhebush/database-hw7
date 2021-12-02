package com.example.databasehw7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw7.domain.Lecture;
import com.example.databasehw7.domain.LectureId;

public interface LectureRepository extends JpaRepository<Lecture, LectureId> {
}
