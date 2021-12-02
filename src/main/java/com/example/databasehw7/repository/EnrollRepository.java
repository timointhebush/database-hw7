package com.example.databasehw7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw7.domain.Enroll;
import com.example.databasehw7.domain.EnrollId;

public interface EnrollRepository extends JpaRepository<Enroll, EnrollId> {
}
