package com.example.mylibrary.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private String photoUrl;
	
	@Column(columnDefinition = "TEXT")
	private String bio;
	
	@OneToMany(mappedBy = "author")
	private List<Book> writtenBooks;
	private Double rating;
	
	public Author() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<Book> getWrittenBooks() {
		return writtenBooks;
	}

	public void setWrittenBooks(List<Book> writtenBooks) {
		this.writtenBooks = writtenBooks;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", NumberOfWrittenBooks=" + writtenBooks.size() + "]";
	}
	
}
