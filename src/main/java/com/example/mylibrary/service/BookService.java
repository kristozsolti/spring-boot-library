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
		List<Book> books = bookRepo.findAll();
		log.info("GET ALL BOOKS. FOUND -> " + books.size());
		return books;
	}

	@Override
	public Book getBookById(Long bookId) {
		Book book = bookRepo.findById(bookId).get();
		log.info("GET BOOK -> " + book.toString());
		return book;
	}

	@Override
	public List<Book> searchBooksByTitle(String bookTitle) {
		List<Book> booksFound = bookRepo.findAllByTitleContainingIgnoreCase(bookTitle);
		log.info("SEARCH BOOKS WITH TITLE -> " + bookTitle + " FOUND " + booksFound.size());
		return booksFound;
	}

	@Override
	public List<Book> getTopRatedBooks() {
		List<Book> books = bookRepo.findTop3ByOrderByRatingDesc();
		log.info("GET TOP RATED BOOKS. FOUND -> " + books.size());
		return books;
	}

	@Override
	public void saveBook(Book newBook) {
		log.info("SAVING NEW BOOK WITH TITLE -> " + newBook.getTitle());
		
		bookRepo.save(newBook);
		
		log.info("BOOK SAVED");
		
	}

}
