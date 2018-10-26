package com.example.mylibrary.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

@Controller
public class ErrorPageController implements ErrorController {

	private static final String ERROR_PATH = "/error";

	@Autowired
	private ErrorAttributes errorAttributes;

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	@RequestMapping(ERROR_PATH)
	public String error(Model model, HttpServletRequest request) {
		ServletWebRequest servletWebRequest = new ServletWebRequest(request);
		Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(servletWebRequest, true);

		model.addAttribute("timestamp", errorAttributes.get("timestamp"));
		model.addAttribute("error", errorAttributes.get("error"));
		model.addAttribute("message", errorAttributes.get("message"));
		model.addAttribute("path", errorAttributes.get("path"));
		model.addAttribute("status", errorAttributes.get("status"));

		return "error/detailedError";
	}

//	@RequestMapping(ERROR_PATH)
//	public String notFound(Model model, HttpServletRequest request) {
//		return "404";
//	}

}
