package com.example.mylibrary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_messages")
public class ContactMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fromName;
	private String fromEmail;
	@Column(columnDefinition = "TEXT")
	private String message;
	private Boolean isReaded;
	
	public ContactMessage() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsReaded() {
		return isReaded;
	}

	public void setIsReaded(Boolean readed) {
		this.isReaded = readed;
	}

	@Override
	public String toString() {
		return "Message [fromName=" + fromName + ", fromEmail=" + fromEmail + ", message=" + message
				+ "]";
	}
	
}
