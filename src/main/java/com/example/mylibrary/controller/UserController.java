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

import com.example.mylibrary.entity.User;
import com.example.mylibrary.entity.UserInfo;
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
	public void register(@ModelAttribute User user, HttpServletResponse response) throws IOException {
		userService.registerUser(user);
		response.sendRedirect("/login?registerSuccess");
	}
	
	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.getAllSimpleUsers());
		return "user/users";
	}
	
	@RequestMapping("/users/{userId}")
	public String user(@PathVariable String userId, Model model) {
		model.addAttribute("user", userService.findById(userId));
		return "user/user";
	}
	
	@GetMapping("/users/search")
	public String searchUsers(@RequestParam String userName, Model model) {
		model.addAttribute("users", userService.searchUsersByName(userName));
		model.addAttribute("searchValue", userName);
		return "user/users";
	}
	
	@RequestMapping("/user-settings") 
	public String userSettings(Model model) {
		model.addAttribute("userInfo", userService.getAuthenticatedUserInfo());
		return "user/settings";
	}
	
	@PostMapping("/user-settings/save")
	public void saveSettings(@ModelAttribute UserInfo userInfo, HttpServletResponse response) throws IOException {
		userService.saveUserInfo(userInfo);
		response.sendRedirect("/user-settings?success");
	}
}
