package com.example.mylibrary.service;

import java.util.List;

import com.example.mylibrary.entity.Book;

public interface IBookService {

	public List<Book> getAllBooks();

	public Book getBookById(String bookId);

	public List<Book> searchBooksByTitle(String bookTitle);

	public List<Book> getTopRatedBooks();

	public void saveBook(Book newBook);
	
}
