package com.moulik.bookkeeper;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.moulik.bookkeeper.bean.Book;
import com.moulik.bookkeeper.repository.BookRepository;

@SpringBootApplication
public class BookKeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookKeeperApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(BookRepository bookRepository) {
		
		return args -> {
			Stream.of("HP1","HP2","HP3").forEach(name-> {
				Book book = new Book(name, "JK Rowling", 180);
				bookRepository.save(book);
			});
			bookRepository.findAll().forEach(System.out::println);
		};
	}

}
