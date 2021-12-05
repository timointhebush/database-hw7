package com.example.databasehw8.bookstore.service;

import com.example.databasehw8.bookstore.domain.Author;
import com.example.databasehw8.bookstore.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
