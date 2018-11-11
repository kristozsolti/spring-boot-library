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

import com.example.mylibrary.entity.UserInfo;
import com.example.mylibrary.service.IUserService;

@Controller
public class UserController {
	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}
	private IUserService userService;
	
	private static final String SEARCH_BY_EMAIL = "email";
	private static final String SEARCH_BY_USERNAME = "username";
	
	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.getAllSimpleUsers());
		return "user/users";
	}
	
	@RequestMapping("/users/{userId}")
	public String user(@PathVariable Long userId, Model model) {
		model.addAttribute("user", userService.findById(userId));
		return "user/user";
	}
	
	@GetMapping("/users/search")
	public String searchUsers(@RequestParam String searchValue, @RequestParam String searchBy, Model model) throws Exception {
		
		if(searchBy.equals(SEARCH_BY_EMAIL)) {
			model.addAttribute("users", userService.searchUsersByEmail(searchValue));
		} else if(searchBy.equals(SEARCH_BY_USERNAME)) {
			model.addAttribute("users", userService.searchUsersByName(searchValue));
		} else {
			throw new Exception("NO SEARCH_BY CRITERIA SELECTED");
		}
		
		model.addAttribute("searchValue", searchValue);
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
