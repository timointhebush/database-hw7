package com.example.databasehw8.bookstore.domain.id;

import com.example.databasehw8.bookstore.domain.Book;
import com.example.databasehw8.bookstore.domain.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Published_byId implements Serializable {

    @JoinColumn(name = "name")
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;

    @JoinColumn(name = "isbn")
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
}
