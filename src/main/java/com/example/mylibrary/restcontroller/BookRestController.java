package com.example.mylibrary.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mylibrary.entity.Book;
import com.example.mylibrary.service.IBookService;

@RestController
@RequestMapping("/api")
public class BookRestController {
	@Autowired
	public BookRestController(IBookService bookService) {
		this.bookService = bookService;
	}
	private IBookService bookService;

	@RequestMapping("/")
	public String index() {
		return "Hello from REST Controller";
	}
	
	@RequestMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping("/book/{id}")
	public Book getBook(@PathVariable Long id) {
		return bookService.getBookById(id);
	}
	
}
