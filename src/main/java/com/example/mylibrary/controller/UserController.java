package com.example.mylibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mylibrary.entity.User;
import com.example.mylibrary.service.IUserService;

@Controller
public class UserController {
	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}
	private IUserService userService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {
		userService.registerUser(user);
		return "login";
	}
	
	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.getAllSimpleUsers());
		return "user/users";
	}
	
	@RequestMapping("/user")
	public String user() {
		
		return "user/user";
	}
}
