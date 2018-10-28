package com.example.mylibrary.service;

import java.util.List;

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
	
	@Override
	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}

	@Override
	public Author getAuthorById(String authorId) {
		Long id = Long.parseLong(authorId);
		return authorRepo.findById(id).get();
	}

}
