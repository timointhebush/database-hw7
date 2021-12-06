package com.example.databasehw8.bookstore.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.databasehw8.bookstore.domain.Author;
import com.example.databasehw8.bookstore.domain.AuthorId;
import com.example.databasehw8.bookstore.domain.Book;
import com.example.databasehw8.bookstore.domain.Published_by;
import com.example.databasehw8.bookstore.domain.Publisher;
import com.example.databasehw8.bookstore.domain.Stocks;
import com.example.databasehw8.bookstore.domain.Warehouse;
import com.example.databasehw8.bookstore.domain.Written_by;
import com.example.databasehw8.bookstore.repository.AuthorRepository;
import com.example.databasehw8.bookstore.repository.BookRepository;
import com.example.databasehw8.bookstore.repository.Published_byRepository;
import com.example.databasehw8.bookstore.repository.PublisherRepository;
import com.example.databasehw8.bookstore.repository.StocksRepository;
import com.example.databasehw8.bookstore.repository.WarehouseRepository;
import com.example.databasehw8.bookstore.repository.Written_byRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class BookService {
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	private PublisherRepository publisherRepository;
	private WarehouseRepository warehouseRepository;
	private StocksRepository stocksRepository;
	private Written_byRepository written_byRepository;
	private Published_byRepository published_byRepository;


	public void registerStocks(HttpServletRequest httpServletRequest, Book book) {
		List<Warehouse> warehouseList = warehouseRepository.findAll();
		for (Warehouse warehouse : warehouseList) {
			String parameter = warehouse.getCode() + "Num";
			String num = httpServletRequest.getParameter(parameter);
			if (num != "") {
				Stocks stocks = new Stocks(book, warehouse, Integer.parseInt(num));
				stocksRepository.saveAndFlush(stocks);
			}
		}
	}

	public Published_by registerPublished_by(Publisher publisher, Book book) {
		Published_by published_by = new Published_by(publisher, book);
		return published_byRepository.save(published_by);
	}

	public Written_by registerWritten_by(Author author, Book book) {
		Written_by written_by = new Written_by(author, book);
		return written_byRepository.save(written_by);
	}

	public Publisher registerPublisher(HttpServletRequest httpServletRequest) {
		String pName = httpServletRequest.getParameter("pName");
		Publisher publisher = new Publisher(pName,
			httpServletRequest.getParameter("pAddress"),
			httpServletRequest.getParameter("phone"),
			httpServletRequest.getParameter("pUrl"));
		return publisherRepository.saveAndFlush(publisher);
	}

	@Transactional
	public Author registerAuthor(HttpServletRequest httpServletRequest) {
		String aName = httpServletRequest.getParameter("aName");
		String aAddress = httpServletRequest.getParameter("aAddress");
		Author author = new Author(aName, aAddress,
			httpServletRequest.getParameter("aUrl"));
		return authorRepository.save(author);
	}

	@Transactional
	public Book registerBook(HttpServletRequest httpServletRequest) {
		Book book = new Book(
			httpServletRequest.getParameter("isbn"),
			httpServletRequest.getParameter("title"),
			Integer.parseInt(httpServletRequest.getParameter("year")),
			Integer.parseInt(httpServletRequest.getParameter("price"))
		);
		return bookRepository.save(book);
	}
}
