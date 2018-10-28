package com.example.mylibrary.service;

import java.util.List;

import com.example.mylibrary.entity.Book;

public interface IBookService {

	public List<Book> getAllBooks();

	public Book getBookById(String bookId);
	
}
