package com.example.databasehw8.bookstore.service;

import com.example.databasehw8.bookstore.domain.Stocks;
import com.example.databasehw8.bookstore.repository.StocksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StocksService {
    private StocksRepository stocksRepository;

    public List<Stocks> findAllByAuthor(String name, String address) {
        return stocksRepository.findAllByAuthor(name, address);
    }
}
