package com.example.databasehw8.bookstore.repository;

import com.example.databasehw8.bookstore.domain.Stocks;
import com.example.databasehw8.bookstore.domain.id.StocksId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StocksRepository extends JpaRepository<Stocks, StocksId> {

    @Query(
        value = "select * from Stocks s " +
                "   join Book b on s.isbn = b.isbn " +
                "   join Written_by w on b.isbn = w.isbn " +
                "where w.name = ?1 and w.address = ?2 ",
        nativeQuery = true
    )
    public List<Stocks> findAllByAuthor(String name, String address);

    @Query(
            value = "select * from Stocks s " +
                    "   join Book b on s.isbn = b.isbn " +
                    "   join Published_By p on b.isbn = p.isbn " +
                    "where p.name = ?1 ",
            nativeQuery = true
    )
    public List<Stocks> findAllByPublisher(String name);
}
