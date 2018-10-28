package com.example.mylibrary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mylibrary.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

	public List<Book> findAll();
	
}
