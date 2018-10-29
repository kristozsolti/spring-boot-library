package com.example.mylibrary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mylibrary.entity.ContactMessage;
import com.example.mylibrary.repository.MessageRepository;
import com.example.mylibrary.shared.ResponseMessage;

@Service
public class ContactMessageService implements IContactMessageService {
	@Autowired
	public ContactMessageService(MessageRepository messageRepo) {
		this.messageRepo = messageRepo;
	}
	private MessageRepository messageRepo;
	private static final Logger log = LoggerFactory.getLogger(ContactMessageService.class);

	@Override
	public ResponseMessage saveMessage(String fromName, String fromEmail, String message) {
		
		
		ContactMessage newMessage = new ContactMessage();
		newMessage.setFromName(fromName);
		newMessage.setFromEmail(fromEmail);
		newMessage.setMessage(message);
		
		log.info("SAVING NEW MESSAGE -> " + newMessage.toString());
		messageRepo.save(newMessage);
		
		return ResponseMessage.success;
		
	}

}
