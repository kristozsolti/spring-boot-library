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

import com.example.mylibrary.entity.Author;
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
	public String author(@PathVariable Long authorId, Model model) {
		model.addAttribute("author", authorService.getAuthorById(authorId));
		return "author/author";
	}
	
	// Search for authors by name
	@GetMapping("/authors/search")
	public String searchAuthors(@RequestParam String authorName, Model model) {
		model.addAttribute("authors", authorService.searchAuthorsByName(authorName));
		model.addAttribute("searchValue", authorName);
		return "author/authors";
	}
	
	@RequestMapping("/authors/add-new")
	public String addNewAuthor(Model model) {
		model.addAttribute("newAuthor", new Author());
		return "author/newAuthor";
	}
	
	@PostMapping("/authors/add-new")
	public void saveNewAuthor(@ModelAttribute Author newAuthor, HttpServletResponse response) throws IOException {
		authorService.saveAuthor(newAuthor);
		response.sendRedirect("/authors");
	}
	
}
