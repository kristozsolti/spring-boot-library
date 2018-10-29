package com.example.mylibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mylibrary.service.IAuthorService;
import com.example.mylibrary.service.IBookService;

@Controller
public class HomeController {
	@Autowired
	public HomeController(IBookService bookService, IAuthorService authorService) {
		this.bookService = bookService;
		this.authorService = authorService;
	}
	private IBookService bookService;
	private IAuthorService authorService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("topBooks", bookService.getTopRatedBooks());
		model.addAttribute("topAuthors", authorService.getTopAuthors());
		return "index";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
}
