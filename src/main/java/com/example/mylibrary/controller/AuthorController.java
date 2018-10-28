package com.example.mylibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mylibrary.service.IAuthorService;

@Controller
public class AuthorController {
	@Autowired
	public AuthorController(IAuthorService authorService) {
		this.authorService = authorService;
	}
	private IAuthorService authorService;

	// All authors page
	@RequestMapping("/authors")
	public String authors(Model model) {
		model.addAttribute("authors", authorService.getAllAuthors());
		return "author/authors";
	}
	
	// Specific author page
	@RequestMapping("/authors/{authorId}")
	public String author(@PathVariable(value = "authorId") String authorId, Model model) {
		model.addAttribute("author", authorService.getAuthorById(authorId));
		return "author/author";
	}
	
}
