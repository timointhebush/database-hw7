package com.example.databasehw8.bookstore.controller;

import com.example.databasehw8.bookstore.domain.Author;
import com.example.databasehw8.bookstore.domain.AuthorId;
import com.example.databasehw8.bookstore.domain.Stocks;
import com.example.databasehw8.bookstore.repository.AuthorRepository;
import com.example.databasehw8.bookstore.service.AuthorService;
import com.example.databasehw8.bookstore.service.StocksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class AuthorController {
    private AuthorService authorService;
    private AuthorRepository authorRepository;
    private StocksService stocksService;

    @GetMapping(value = "/author")
    public ModelAndView authors() {
        List<Author> authorList = authorService.findAll();
        ModelAndView modelAndView = new ModelAndView("2aAuthor");
        modelAndView.addObject("authorList", authorList);
        return modelAndView;
    }

    @GetMapping(value = "/author/book")
    public ModelAndView authorBooks(@RequestParam String name, @RequestParam String address) {
        List<Stocks> stocksList = stocksService.findAllByAuthor(name, address);
        Author author = authorRepository.getById(
                new AuthorId(name, address)
        );
        ModelAndView modelAndView = new ModelAndView("2aAuthorBooks");
        modelAndView.addObject("authorName", author.getName());
        modelAndView.addObject("stocksList", stocksList);
        return modelAndView;
    }
}
