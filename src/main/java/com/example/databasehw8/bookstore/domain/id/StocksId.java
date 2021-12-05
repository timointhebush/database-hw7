package com.example.databasehw8.bookstore.domain.id;

import com.example.databasehw8.bookstore.domain.Book;
import com.example.databasehw8.bookstore.domain.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StocksId implements Serializable {
    private Book book;

    private Warehouse warehouse;
}
