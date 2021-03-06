package com.example.mylibrary.service;

import java.util.List;

import com.example.mylibrary.entity.Author;

public interface IAuthorService {

	public List<Author> getAllAuthors();

	public Author getAuthorById(Long authorId);

	public List<Author> searchAuthorsByName(String authorName);

	public List<Author> getTopAuthors();

	public void saveAuthor(Author newAuthor);

}
