package com.moulik.bookkeeper.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String author;
	private int pages;
	
	public Book() {
		
	}
	public Book(String name, String author, int pages) {
		super();
		this.name = name;
		this.author = author;
		this.pages = pages;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", pages=" + pages + "]";
	}
	
}
