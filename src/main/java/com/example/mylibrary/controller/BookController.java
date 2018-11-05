package com.example.mylibrary.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mylibrary.entity.Book;
import com.example.mylibrary.service.IAuthorService;
import com.example.mylibrary.service.IBookService;

@Controller
public class BookController {
	@Autowired
	public BookController(IBookService bookService, IAuthorService authorService) {
		this.bookService = bookService;
		this.authorService = authorService;
	}
	private IAuthorService authorService;
	private IBookService bookService;

	// All books page
	@RequestMapping("/books")
	public String books(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "book/books";
	}

	// Specific book page
	@RequestMapping("/books/{bookId}")
	public String book(@PathVariable String bookId, Model model) {
		model.addAttribute("book", bookService.getBookById(bookId));
		return "book/book";
	}

	// Search for books by title
	@GetMapping("/books/search")
	public String searchBooks(@RequestParam String bookTitle, Model model) {
		model.addAttribute("books", bookService.searchBooksByTitle(bookTitle));
		model.addAttribute("searchValue", bookTitle);
		return "book/books";
	}
	
	@RequestMapping("/books/add-new")
	public String addNewBook(Model model) {
		model.addAttribute("newBook", new Book());
		model.addAttribute("authors", authorService.getAllAuthors());
		return "book/newBook";
	}
	
	@PostMapping("/books/add-new")
	public void saveNewBook(@ModelAttribute Book newBook, HttpServletResponse response) throws IOException {
		bookService.saveBook(newBook);
		response.sendRedirect("/books");
	}
	

}
