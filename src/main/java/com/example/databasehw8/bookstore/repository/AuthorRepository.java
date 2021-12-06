package com.example.databasehw8.bookstore.repository;

import com.example.databasehw8.bookstore.domain.Author;
import com.example.databasehw8.bookstore.domain.id.AuthorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, AuthorId> {
}
