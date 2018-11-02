package com.example.mylibrary.service;

import java.util.List;

import com.example.mylibrary.entity.ContactMessage;
import com.example.mylibrary.shared.ResponseMessage;

public interface IContactMessageService {

	public ResponseMessage saveMessage(String fromName, String fromEmail, String message);

	public List<ContactMessage> getAllMessages();

	public ContactMessage getMessageById(Long id);
	
}
