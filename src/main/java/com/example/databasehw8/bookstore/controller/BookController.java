package com.example.databasehw8.bookstore.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.databasehw8.bookstore.domain.Author;
import com.example.databasehw8.bookstore.domain.AuthorId;
import com.example.databasehw8.bookstore.domain.Book;
import com.example.databasehw8.bookstore.domain.Published_by;
import com.example.databasehw8.bookstore.domain.Publisher;
import com.example.databasehw8.bookstore.domain.Warehouse;
import com.example.databasehw8.bookstore.domain.Written_by;
import com.example.databasehw8.bookstore.repository.AuthorRepository;
import com.example.databasehw8.bookstore.repository.BookRepository;
import com.example.databasehw8.bookstore.repository.PublisherRepository;
import com.example.databasehw8.bookstore.repository.WarehouseRepository;
import com.example.databasehw8.bookstore.service.BookService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BookController {
	private WarehouseRepository warehouseRepository;
	private BookService bookService;
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	private PublisherRepository publisherRepository;

	@GetMapping(value = "/book/register")
	public ModelAndView registerBookForm() {
		List<Warehouse> warehouseList = warehouseRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("2dnewBook");
		modelAndView.addObject("warehouseList", warehouseList);
		return modelAndView;
	}

	@PostMapping(value = "/book/register")
	public ModelAndView registerBook(HttpServletRequest httpServletRequest) {
		Book book = bookService.registerBook(httpServletRequest);
		Author author = bookService.registerAuthor(httpServletRequest);
		// Written_by written_by = bookService.registerWritten_by(author, book);
		Publisher publisher = bookService.registerPublisher(httpServletRequest);
		// Published_by published_by = bookService.registerPublished_by(publisher, book);
		ModelAndView modelAndView = new ModelAndView("2dAfterRegister");
		bookService.registerStocks(httpServletRequest, book);
		modelAndView.addObject("book", book);
		modelAndView.addObject("author", author);
		modelAndView.addObject("publisher", publisher);
		return modelAndView;
	}
}
