package com.example.mylibrary.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mylibrary.entity.User;
import com.example.mylibrary.service.IAuthService;
import com.example.mylibrary.shared.ResponseMessage;

@Controller
public class AuthController {
	@Autowired
	public AuthController(IAuthService authService) {
		this.authService = authService;
	}

	private IAuthService authService;

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
		ResponseMessage respMsg = authService.registerUser(user);

		if (respMsg.equals(ResponseMessage.success)) {
			response.sendRedirect("/login?registerSuccess");
		} else if (respMsg.equals(ResponseMessage.error)) {
			response.sendRedirect("/registration?userExists");
		}
	}

}
