package com.example.mylibrary.service;

import java.util.List;

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

	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

}
