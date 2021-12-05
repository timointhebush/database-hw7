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

	public Book constructBook(HttpServletRequest httpServletRequest) {
		Book book = new Book(
			httpServletRequest.getParameter("isbn"),
			httpServletRequest.getParameter("title"),
			Integer.parseInt(httpServletRequest.getParameter("year")),
			Integer.parseInt(httpServletRequest.getParameter("price"))
		);
		return book;
	}

	public Author constructAuthor(HttpServletRequest httpServletRequest) {
		String aName = httpServletRequest.getParameter("aName");
		String aAddress = httpServletRequest.getParameter("aAddress");
		AuthorId authorId = new AuthorId(aName, aAddress);
		Author author;
		try {
			author = authorRepository.getById(authorId);
		} catch (Exception e) {
			author = new Author(aName, aAddress, httpServletRequest.getParameter("aUrl"));
		}
		return author;
	}

	public Publisher constructPublisher(HttpServletRequest httpServletRequest) {
		String pName = httpServletRequest.getParameter("pName");
		Publisher publisher;
		try {
			publisher = publisherRepository.getById(pName);
		} catch (EntityNotFoundException e) {
			publisher = new Publisher(pName,
				httpServletRequest.getParameter("pAddress"),
				httpServletRequest.getParameter("phone"),
				httpServletRequest.getParameter("pUrl"));
		}
		return publisher;
	}

	@Transactional
	public void registerBook(HttpServletRequest httpServletRequest) {
		Book book = constructBook(httpServletRequest);
		bookRepository.saveAndFlush(book);
		System.out.println(book.getIsbn());

		Author author = constructAuthor(httpServletRequest);
		System.out.println(author.getName());
		authorRepository.saveAndFlush(author);

		Written_by written_by = new Written_by(author, book);
		written_byRepository.saveAndFlush(written_by);
		System.out.println(written_by.getBook().getIsbn());

		Publisher publisher = constructPublisher(httpServletRequest);
		publisherRepository.saveAndFlush(publisher);
		System.out.println(publisher.getName());

		Published_by published_by = new Published_by(publisher, book);
		published_byRepository.saveAndFlush(published_by);


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
}
