package com.moulik.bookkeeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moulik.bookkeeper.bean.Book;
import com.moulik.bookkeeper.repository.BookRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
	
	@Autowired
	private final BookRepository bookRepository = null;
	
	@GetMapping(path="/books")
	public List<Book> getAllBooks() {
		return (List<Book>)bookRepository.findAll();
	}
	
	@PostMapping("/books")
	public void addBook(@RequestBody Book book) {
		bookRepository.save(book);
	}
	
	
}
