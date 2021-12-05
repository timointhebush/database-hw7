package com.example.databasehw8.bookstore.repository;

import com.example.databasehw8.bookstore.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
