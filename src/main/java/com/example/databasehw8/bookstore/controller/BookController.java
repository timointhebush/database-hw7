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
import com.example.databasehw8.bookstore.domain.Publisher;
import com.example.databasehw8.bookstore.domain.Warehouse;
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
		try {
			bookService.registerBook(httpServletRequest);
			String isbn = httpServletRequest.getParameter("isbn");
			Book book = bookRepository.getById(isbn);

			String aName = httpServletRequest.getParameter("aName");
			String aAddress = httpServletRequest.getParameter("aAddress");
			Author author = authorRepository.getById(new AuthorId(aName, aAddress));

			String pName = httpServletRequest.getParameter("pName");
			Publisher publisher = publisherRepository.getById(pName);
			ModelAndView modelAndView = new ModelAndView("2dAfterRegister");
			modelAndView.addObject("book", book);
			modelAndView.addObject("author", author);
			modelAndView.addObject("publisher", publisher);
			return modelAndView;
		} catch (Exception e) {
			return new ModelAndView("2dAfterRegister");
		}

	}
}
