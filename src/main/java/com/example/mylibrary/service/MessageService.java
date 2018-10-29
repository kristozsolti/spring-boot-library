package com.example.mylibrary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mylibrary.entity.Message;
import com.example.mylibrary.repository.MessageRepository;
import com.example.mylibrary.shared.ResponseMessage;

@Service
public class MessageService implements IMessageService {
	@Autowired
	public MessageService(MessageRepository messageRepo) {
		this.messageRepo = messageRepo;
	}
	private MessageRepository messageRepo;
	private static final Logger log = LoggerFactory.getLogger(MessageService.class);

	@Override
	public ResponseMessage saveMessage(String fromName, String fromEmail, String message) {
		
		
		Message newMessage = new Message();
		newMessage.setFromName(fromName);
		newMessage.setFromEmail(fromEmail);
		newMessage.setMessage(message);
		
		log.info("SAVING NEW MESSAGE -> " + newMessage.toString());
		messageRepo.save(newMessage);
		
		return ResponseMessage.SUCCESS;
		
	}

}
