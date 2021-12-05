package com.example.databasehw8.bookstore.domain.id;

import com.example.databasehw8.bookstore.domain.Book;
import com.example.databasehw8.bookstore.domain.Shopping_basket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContainsId implements Serializable {
    private Shopping_basket shopping_basket;
    private Book book;
}
