package com.example.databasehw8.bookstore.repository;

import com.example.databasehw8.bookstore.domain.Stocks;
import com.example.databasehw8.bookstore.domain.id.StocksId;
import com.example.databasehw8.bookstore.projection.SumStocksBook;

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

    @Query(value = "select s.isbn as isbn, sum(s.num) as totalStock "
        + "from Stocks s "
        + "group by s.isbn "
        + "having sum(s.num) >= ?1 ",
        nativeQuery = true)
    public List<SumStocksBook> findBySumStocks(Integer stockNum);

    @Query(value = "update Book b set b.price = b.price * ?2 "
        + "where b.isbn in ( "
        + "     select b2.isbn from Stocks s join Book b2 on s.isbn = b2.isbn "
        + "     group by b2.isbn "
        + "     having sum(s.num) >= ?1)", nativeQuery = true)
    public void updatePrice(Integer stockNum, double discountRate);
}
