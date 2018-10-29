package com.example.mylibrary.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(GeneralExceptionHandler.class);

	@ExceptionHandler
	public String exception(Exception ex, Model model) {
		model.addAttribute("exception", ex);
		log.error("EXCEPTION CAUGHT -> " + ex);
		return "exception/generalException";
	}

}
