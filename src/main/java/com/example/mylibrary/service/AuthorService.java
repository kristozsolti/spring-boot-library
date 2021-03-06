package com.example.mylibrary.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mylibrary.entity.Author;
import com.example.mylibrary.repository.AuthorRepository;

@Service
public class AuthorService implements IAuthorService {
	@Autowired
	public AuthorService(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
	}
	private AuthorRepository authorRepo;
	private static final Logger log = LoggerFactory.getLogger(AuthorService.class);
	
	@Override
	public List<Author> getAllAuthors() {
		List<Author> authors = authorRepo.findAll();
		log.info("GET ALL AUTHORS. FOUND -> " + authors.size());
		return authors;
	}

	@Override
	public Author getAuthorById(Long authorId) {
		Author author = authorRepo.findById(authorId).get();
		log.info("GET AUTHOR -> " + author.toString());
		return author;
	}

	@Override
	public List<Author> searchAuthorsByName(String authorName) {
		List<Author> authorsFound = authorRepo.findAllByNameContainingIgnoreCase(authorName);
		log.info("SEARCH AUTHORS WITH NAME -> " + authorName + " FOUND " + authorsFound.size());
		return authorsFound;
	}

	@Override
	public List<Author> getTopAuthors() {
		List<Author> authors = authorRepo.findTop3ByOrderByRatingDesc();
		log.info("GET TOP AUTHORS. FOUND -> " + authors.size());
		return authors;
	}

	@Override
	public void saveAuthor(Author newAuthor) {
		log.info("SAVING NEW AUTHOR WITH NAME -> " + newAuthor.getName());
		
		authorRepo.save(newAuthor);
		
		log.info("AUTHOR SAVED");
	}

}
