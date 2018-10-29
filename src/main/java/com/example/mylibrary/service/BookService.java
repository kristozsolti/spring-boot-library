package com.example.mylibrary.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mylibrary.entity.Book;
import com.example.mylibrary.repository.BookRepository;

@Service
public class BookService implements IBookService {
	@Autowired
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	private BookRepository bookRepo;
	private static final Logger log = LoggerFactory.getLogger(BookService.class);

	@Override
	public List<Book> getAllBooks() {
		log.info("GET ALL BOOKS.");
		return bookRepo.findAll();
	}

	@Override
	public Book getBookById(String bookId) {
		Long id = Long.parseLong(bookId);
		Book book = bookRepo.findById(id).get();
		log.info("GET BOOK -> " + book.toString());
		return book;
	}

}
