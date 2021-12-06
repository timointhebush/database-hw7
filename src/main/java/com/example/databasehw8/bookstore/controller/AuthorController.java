package com.example.databasehw8.bookstore.controller;

import com.example.databasehw8.bookstore.domain.Author;
import com.example.databasehw8.bookstore.domain.id.AuthorId;
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

    /**
     * 모든 작가들의 정보를 확인
     * @return
     */
    @GetMapping(value = "/author")
    public ModelAndView authors() {
        List<Author> authorList = authorService.findAll();
        ModelAndView modelAndView = new ModelAndView("2aAuthor");
        modelAndView.addObject("authorList", authorList);
        return modelAndView;
    }

    /**
     * 선택한 작가가 쓴 책의 제목, 재고를 확인
     * @param name
     * @param address
     * @return
     */
    @GetMapping(value = "/author/book")
    public ModelAndView authorBooks(@RequestParam String name, @RequestParam String address) {
        List<Stocks> stocksList = stocksService.findAllByAuthor(name, address);
        Author author = authorRepository.getById(
                new AuthorId(name, address)
        );
        ModelAndView modelAndView = new ModelAndView("2aAuthorBooks");
        modelAndView.addObject("authorName", author.getAuthorId().getName());
        modelAndView.addObject("stocksList", stocksList);
        return modelAndView;
    }
}
