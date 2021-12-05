package com.example.databasehw8.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw8.bookstore.domain.Written_by;
import com.example.databasehw8.bookstore.domain.id.Written_byId;

public interface Written_byRepository extends JpaRepository<Written_by, Written_byId> {
}
