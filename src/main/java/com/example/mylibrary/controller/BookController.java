package com.example.mylibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mylibrary.service.IBookService;

@Controller
public class BookController {
	@Autowired
	public BookController(IBookService bookService) {
		this.bookService = bookService;
	}
	private IBookService bookService;

	@RequestMapping("/books")
	public String books(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "book/books";
	}
	
	@RequestMapping("/books/{bookId}")
	public String book(@PathVariable(value = "bookId") String bookId, Model model) {
		model.addAttribute("book", bookService.getBookById(bookId));
		return "book/book";
	}
	
}
