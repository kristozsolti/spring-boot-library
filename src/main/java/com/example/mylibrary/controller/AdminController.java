package com.example.mylibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/")
	public String dashboard() {
		return "admin/dashboard";
	}
	
	@RequestMapping("/contact-messages")
	public String contactMessages() {
		return "admin/contactMessages";
	}
}
