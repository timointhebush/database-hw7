package com.example.databasehw8.bookstore.repository;

import com.example.databasehw8.bookstore.domain.Contains;
import com.example.databasehw8.bookstore.domain.Stocks;
import com.example.databasehw8.bookstore.domain.id.ContainsId;
import com.example.databasehw8.bookstore.projection.BookPublisherAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContainsRepository extends JpaRepository<Contains, ContainsId> {
    @Query(
            value = "select b.title bname, p.name pname, w.name aname " +
                    "from Book b "
                +   "join Written_by w on b.isbn = w.isbn "
                +   "join Contains c on c.isbn = b.isbn "
                +   "join Published_by p on b.isbn = p.isbn " +
                    "where c.basketid = ( "
                +       "select bo.basketid from Basket_of bo where bo.email = ?1) ",
            nativeQuery = true
    )
    public List<BookPublisherAuthor> findAllByCustomer(String email);
}
