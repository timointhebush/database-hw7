package com.example.databasehw8.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw8.bookstore.domain.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}
