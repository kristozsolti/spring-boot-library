package com.example.mylibrary.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mylibrary.entity.ContactMessage;
import com.example.mylibrary.service.IAuthorService;
import com.example.mylibrary.service.IBookService;
import com.example.mylibrary.service.IContactMessageService;
import com.example.mylibrary.shared.ResponseMessage;

@Controller
public class HomeController {
	@Autowired
	public HomeController(IBookService bookService, IAuthorService authorService, IContactMessageService messageService) {
		this.bookService = bookService;
		this.authorService = authorService;
		this.messageService = messageService;
		
	}
	private IBookService bookService;
	private IAuthorService authorService;
	private IContactMessageService messageService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("topBooks", bookService.getTopRatedBooks());
		model.addAttribute("topAuthors", authorService.getTopAuthors());
		return "index";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("newMessage", new ContactMessage());
		return "contact";
	}
	
	@PostMapping("/save-message")
	public void saveMessage(@ModelAttribute ContactMessage newMessage, HttpServletResponse response) throws IOException {
		ResponseMessage saveMsg = messageService.saveMessage(newMessage);
		response.sendRedirect("/contact?" + saveMsg);
	}
}
