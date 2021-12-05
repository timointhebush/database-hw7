package com.example.databasehw8.bookstore.domain.id;

import com.example.databasehw8.bookstore.domain.Author;
import com.example.databasehw8.bookstore.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Written_byId implements Serializable {
    private Author author;

    private Book book;
}
