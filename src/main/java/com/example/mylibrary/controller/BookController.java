package com.example.mylibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String book(@PathVariable String bookId, Model model) {
		model.addAttribute("book", bookService.getBookById(bookId));
		return "book/book";
	}

	@GetMapping("/books/search")
	public String getMethodName(@RequestParam String bookTitle, Model model) {
		model.addAttribute("books", bookService.getBooksByTitle(bookTitle));
		return "book/books";
	}

}
