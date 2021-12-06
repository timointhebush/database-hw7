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
import com.example.databasehw8.bookstore.projection.SumNumByBook;
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

	/**
	 * 2-f) 새로운 도서를 등록하기 위한 form
	 * @return
	 */
	@GetMapping(value = "/book/register")
	public ModelAndView registerBookForm() {
		List<Warehouse> warehouseList = warehouseRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("2dnewBook");
		modelAndView.addObject("warehouseList", warehouseList);
		return modelAndView;
	}

	/**
	 * 2-f) 도서 등록을 위한 Service 메소드 호출
	 * @param httpServletRequest
	 * @return
	 */
	@PostMapping(value = "/book/register")
	public ModelAndView registerBook(HttpServletRequest httpServletRequest) {
		Book book = bookService.registerBook(httpServletRequest);
		Author author = bookService.registerAuthor(httpServletRequest);
		Publisher publisher = bookService.registerPublisher(httpServletRequest);
		bookService.registerStocks(httpServletRequest, book);
		ModelAndView modelAndView = new ModelAndView("2dAfterRegister");
		modelAndView.addObject("book", book.getTitle());
		modelAndView.addObject("author", author.getAuthorId().getName());
		modelAndView.addObject("publisher", publisher.getName());
		return modelAndView;
	}

	/**
	 * 2-e) 전체 도서의 평균 가격, 년도 별 평균 가격
	 * @return
	 */
	@GetMapping(value = "/book/price")
	public ModelAndView avgPrice() {
		List<AvgBookPrice> avgBookPrices = bookRepository.getAvgPrice();
		List<AvgBookPriceByYear> avgBookPriceByYears = bookRepository.getAvgPriceByYear();
		ModelAndView modelAndView = new ModelAndView("2eAvgPrice");
		modelAndView.addObject("avgBookPrices", avgBookPrices);
		modelAndView.addObject("avgBookPriceByYears", avgBookPriceByYears);
		return modelAndView;
	}

	/**
	 * 2-f) 작가 별 총 개수, 최고, 최저, 평균 가격
	 * @return
	 */
	@GetMapping(value = "/book/author")
	public ModelAndView cntMinMaxAvgByAuthor() {
		List<CntMinMaxAvgByAuthor> cntMinMaxAvgByAuthors = bookRepository.getCntMinMaxAvgByAuthor();
		ModelAndView modelAndView = new ModelAndView("2fBookByAuthor");
		modelAndView.addObject("cntMinMaxAvgByAuthors", cntMinMaxAvgByAuthors);
		return modelAndView;
	}

	/**
	 * 2-g) 특정 재고 이상의 책들을 확인
	 * @param pivotNum
	 * @return
	 */
	@GetMapping(value = "/book/stocks")
	public ModelAndView bookStocks(@RequestParam Integer pivotNum) {
		return showStocksBook(pivotNum);
	}

	/**
	 * 2-g) 특정 재고 이상의 책들을 원하는 정도 할인
	 * @param discountPercent
	 * @param pivotNum
	 * @return
	 */
	@GetMapping(value = "/book/discount")
	public ModelAndView discountPrice(@RequestParam Integer discountPercent, @RequestParam Integer pivotNum) {
		double discountRate = (100 - discountPercent)*0.01;
		List<Book> bookList = bookRepository.findBookOverStock(pivotNum);
		bookService.updatePrice(bookList, discountRate);
		return showStocksBook(pivotNum);
	}

	/**
	 * 2-g) 특정 재고 이상의 책들을 확인, 공통 메소드
	 * @param pivotNum
	 * @return
	 */
	public ModelAndView showStocksBook(Integer pivotNum) {
		List<SumNumByBook> sumNumByBooks = stocksRepository.findBookNumOverStock(pivotNum);
		List<Book> bookList = bookRepository.findBookOverStock(pivotNum);
		ModelAndView modelAndView = new ModelAndView("2gBooksOverStock");
		modelAndView.addObject("pivotNum", pivotNum);
		modelAndView.addObject("sumNumByBooks", sumNumByBooks);
		modelAndView.addObject("bookList", bookList);
		return modelAndView;
	}


}
