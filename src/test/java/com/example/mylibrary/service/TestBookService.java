package com.example.mylibrary.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.mylibrary.entity.Author;
import com.example.mylibrary.entity.Book;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBookService {
	
	BookService bookService = Mockito.mock(BookService.class);
	
	List<Book> books = new ArrayList<>();
	
	Book b1 = new Book();
	Book b2 = new Book();
	
	Author a1 = new Author();
	Author a2 = new Author();

	@Before
	public void init() {
		
		this.setupAuthors();
		this.setupBooks();
		
	}
	
	@Test
	public void testGetAllBooks() {
		when(bookService.getAllBooks()).thenReturn(books);
		
		List<Book> expected = books;
		
		assertEquals(expected, bookService.getAllBooks());
		
		verify(bookService).getAllBooks();
	}
	
	private void setupAuthors() {
		a1.setId((long) 1);
		a1.setName("Author1");
		a1.setRating(3.6);
		a1.setWrittenBooks(new ArrayList<Book>());
		a1.setDateOfBirth(new Date());
		a1.setBio("Biography");
		
		a2.setId((long) 2);
		a2.setName("Author2");
		a2.setRating(3.9);
		a2.setWrittenBooks(new ArrayList<Book>());
		a2.setDateOfBirth(new Date());
		a2.setBio("Biography 2");
	}
	
	private void setupBooks() {
		b1.setId((long) 1);
		b1.setTitle("Book1");
		b1.setAuthor(a1);
		b1.setDescription("Description");
		b1.setIsbn("124567890");
		b1.setNumberOfPages(1024);
		b1.setPhotoUrl("http://example.com/photo.jpg");
		b1.setPublicatedBy("Publicator 1");
		b1.setPublicationYear(1995);
		b1.setRating(4.6);
		
		b2.setId((long) 2);
		b2.setTitle("Book2");
		b2.setAuthor(a1);
		b2.setDescription("Description 2");
		b2.setIsbn("124567891");
		b2.setNumberOfPages(512);
		b2.setPhotoUrl("http://example.com/photo2.jpg");
		b2.setPublicatedBy("Publicator 2");
		b2.setPublicationYear(1999);
		b2.setRating(4.9);
	}
	
}
