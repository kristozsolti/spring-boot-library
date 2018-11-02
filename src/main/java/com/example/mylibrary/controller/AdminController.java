package com.example.mylibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mylibrary.service.IContactMessageService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	public AdminController(IContactMessageService messageService) {
		this.messageService = messageService;
	}
	private IContactMessageService messageService;

	@RequestMapping("/")
	public String dashboard() {
		return "admin/dashboard";
	}
	
	@RequestMapping("/contact-messages")
	public String contactMessages(Model model) {
		model.addAttribute("messages", messageService.getAllMessages());
		return "admin/contactMessages";
	}
	
	@RequestMapping("/contact-messages/{msgId}")
	public String contactMessage(@PathVariable Long msgId, Model model) {
		model.addAttribute("message", messageService.getMessageById(msgId));
		return "admin/contactMessage";
	}
}
