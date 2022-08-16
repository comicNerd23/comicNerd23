package com.moulik.bookkeeper.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.moulik.bookkeeper.domain.Book;
import com.moulik.bookkeeper.exception.BookKeeperException;
import com.moulik.bookkeeper.service.BookService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class BookController {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private final BookService bookService = null;
	
	@GetMapping(path="/books", produces = "application/json")
	@ResponseBody
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@PostMapping("/books")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
	
	@GetMapping(path="/books/{id}")
	public Book getBook(@PathVariable(value = "id") Long id) {
		return bookService.getBookById(id);
	}
	
	@PutMapping("/books/{id}")
	public void updateBook(@RequestBody Book book, @PathVariable("id") Long id) {
		bookService.updateBook(book, id);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(BookKeeperException.class)
	public ModelAndView handleNotFound(Exception exc) {
		LOGGER.error("Handling not found");
		LOGGER.error(exc.getMessage());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("404Error");
		modelAndView.addObject("exception",exc);
		
		return modelAndView;
	}
	
	
	
}
