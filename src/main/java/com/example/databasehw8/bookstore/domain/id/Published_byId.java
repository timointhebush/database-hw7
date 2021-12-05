package com.example.databasehw8.bookstore.domain.id;

import com.example.databasehw8.bookstore.domain.Book;
import com.example.databasehw8.bookstore.domain.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Published_byId implements Serializable {
    private Publisher publisher;
    private Book book;
}
