package com.example.databasehw8.bookstore.projection;

public interface CntMinMaxAvgByAuthor {
    String getAname();
    Integer getCnt();
    Integer getMaxPrice();
    Integer getMinPrice();
    Float getAvgPrice();
}
