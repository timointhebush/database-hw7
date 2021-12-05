package com.example.databasehw8.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw8.bookstore.domain.Published_by;
import com.example.databasehw8.bookstore.domain.id.Published_byId;

public interface Published_byRepository extends JpaRepository<Published_by, Published_byId> {
}
