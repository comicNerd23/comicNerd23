package com.moulik.bookkeeper.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moulik.bookkeeper.bean.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

}
