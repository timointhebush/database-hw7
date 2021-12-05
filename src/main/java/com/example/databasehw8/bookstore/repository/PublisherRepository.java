package com.example.databasehw8.bookstore.repository;

import com.example.databasehw8.bookstore.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
}
