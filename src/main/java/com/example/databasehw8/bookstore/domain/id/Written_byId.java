package com.example.databasehw8.bookstore.domain.id;

import com.example.databasehw8.bookstore.domain.Author;
import com.example.databasehw8.bookstore.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Written_byId implements Serializable {

    @JoinColumns({
        @JoinColumn(name = "name"),
        @JoinColumn(name = "address")
    })
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @JoinColumn(name = "isbn")
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
}
