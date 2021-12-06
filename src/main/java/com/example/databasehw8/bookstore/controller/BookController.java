package com.example.databasehw8.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.databasehw8.bookstore.domain.Author;
import com.example.databasehw8.bookstore.domain.Book;
import com.example.databasehw8.bookstore.domain.Publisher;
import com.example.databasehw8.bookstore.domain.Warehouse;
import com.example.databasehw8.bookstore.projection.AvgBookPrice;
import com.example.databasehw8.bookstore.projection.AvgBookPriceByYear;
import com.example.databasehw8.bookstore.projection.CntMinMaxAvgByAuthor;
import com.example.databasehw8.bookstore.projection.SumStocksBook;
import com.example.databasehw8.bookstore.repository.AuthorRepository;
import com.example.databasehw8.bookstore.repository.BookRepository;
import com.example.databasehw8.bookstore.repository.PublisherRepository;
import com.example.databasehw8.bookstore.repository.StocksRepository;
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
	private StocksRepository stocksRepository;

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

	@GetMapping(value = "/book/price")
	public ModelAndView avgPrice() {
		List<AvgBookPrice> avgBookPrices = bookRepository.getAvgPrice();
		List<AvgBookPriceByYear> avgBookPriceByYears = bookRepository.getAvgPriceByYear();
		ModelAndView modelAndView = new ModelAndView("2eAvgPrice");
		modelAndView.addObject("avgBookPrices", avgBookPrices);
		modelAndView.addObject("avgBookPriceByYears", avgBookPriceByYears);
		return modelAndView;
	}

	@GetMapping(value = "/book/author")
	public ModelAndView cntMinMaxAvgByAuthor() {
		List<CntMinMaxAvgByAuthor> cntMinMaxAvgByAuthors = bookRepository.getCntMinMaxAvgByAuthor();
		ModelAndView modelAndView = new ModelAndView("2fBookByAuthor");
		modelAndView.addObject("cntMinMaxAvgByAuthors", cntMinMaxAvgByAuthors);
		return modelAndView;
	}

	@GetMapping(value = "/book/stocks")
	public ModelAndView bookStocks(@RequestParam Integer stockNum) {
		List<SumStocksBook> sumStocksBooks = stocksRepository.findBySumStocks(stockNum);
		List<Book> bookList = bookRepository.findBySumStocks(stockNum);
		ModelAndView modelAndView = new ModelAndView("2gBooksOverStock");
		modelAndView.addObject("stockNum", stockNum);
		modelAndView.addObject("sumStocksBooks", sumStocksBooks);
		modelAndView.addObject("bookList", bookList);
		return modelAndView;
	}

	@GetMapping(value = "/book/discount")
	public ModelAndView discountPrice(@RequestParam Integer discountPercent, @RequestParam Integer stockNum) {
		double discountRate = (100 - discountPercent)*0.01;
		stocksRepository.updatePrice(stockNum, discountRate);
		List<SumStocksBook> sumStocksBooks = stocksRepository.findBySumStocks(stockNum);
		List<Book> bookList = bookRepository.findBySumStocks(stockNum);
		ModelAndView modelAndView = new ModelAndView("2gBooksOverStock");
		modelAndView.addObject("stockNum", stockNum);
		modelAndView.addObject("sumStocksBooks", sumStocksBooks);
		modelAndView.addObject("bookList", bookList);
		return modelAndView;
	}


}
