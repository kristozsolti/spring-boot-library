package com.example.mylibrary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mylibrary.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

	public List<Author> findAll();
	
	public List<Author> findAllByNameContainingIgnoreCase(String authorName);

	public List<Author> findTop3ByOrderByRatingDesc();
	
}
