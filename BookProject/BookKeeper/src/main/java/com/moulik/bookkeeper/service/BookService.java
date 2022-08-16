package com.moulik.bookkeeper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moulik.bookkeeper.domain.Book;
import com.moulik.bookkeeper.exception.BookKeeperException;
import com.moulik.bookkeeper.repository.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	@Autowired
	BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(x->books.add(x));
		return books;
	}

	public Book getBookById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if(book.isEmpty()) {
			throw new BookKeeperException("Book Not Found. For ID value: " + id.toString() );
		}
		return book.get();
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	public void updateBook(Book book, Long id) {
		Book book1 = book;
		book1.setId(id);
		bookRepository.save(book1);
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	

}
