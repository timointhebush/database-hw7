package com.example.databasehw8.bookstore.controller;

import com.example.databasehw8.bookstore.domain.Publisher;
import com.example.databasehw8.bookstore.domain.Stocks;
import com.example.databasehw8.bookstore.repository.PublisherRepository;
import com.example.databasehw8.bookstore.repository.StocksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class PublisherController {
    private PublisherRepository publisherRepository;
    private StocksRepository stocksRepository;

    @GetMapping(value = "/publisher")
    public ModelAndView publishers() {
        List<Publisher> publisherList = publisherRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("2bPublisher");
        modelAndView.addObject("publisherList", publisherList);
        return modelAndView;
    }

    @GetMapping(value = "/publisher/book/")
    public ModelAndView publisherBooks(@RequestParam String name) {
        List<Stocks> stocksList = stocksRepository.findAllByPublisher(name);
        Publisher publisher = publisherRepository.getById(name);
        ModelAndView modelAndView = new ModelAndView("2bPublisherBooks");
        modelAndView.addObject("publisherName", publisher.getName());
        modelAndView.addObject("stocksList", stocksList);
        return modelAndView;
    }
}
