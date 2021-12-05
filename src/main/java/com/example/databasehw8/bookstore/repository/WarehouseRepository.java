package com.example.databasehw8.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.databasehw8.bookstore.domain.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, String> {
}
