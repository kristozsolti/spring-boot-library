package com.example.mylibrary.service;

import java.util.List;

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
		newMessage.setIsReaded(false);
		
		log.info("SAVING NEW MESSAGE -> " + newMessage.toString());
		messageRepo.save(newMessage);
		
		return ResponseMessage.success;
		
	}

	@Override
	public List<ContactMessage> getAllMessages() {
		List<ContactMessage> messages = messageRepo.findAll();
		log.info("GET ALL MESSAGES. FOUND -> " + messages.size());
		return messages;
	}

	@Override
	public ContactMessage getMessageById(Long id) {
		ContactMessage msg = messageRepo.findById(id).get();
		log.info("GET MESSAGE -> " + msg);
		
		msg.setIsReaded(true);
		messageRepo.save(msg);
		
		return msg;
	}

}
