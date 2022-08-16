package com.moulik.bookkeeper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {

	private static final Logger LOGGER= LoggerFactory.getLogger(BookController.class);
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView numberFormatException(Exception exc) {
		LOGGER.error("Wrong Format of String");
		LOGGER.error(exc.getMessage());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("400Error");
		modelAndView.addObject("exception",exc);
		
		return modelAndView;
	}
}
