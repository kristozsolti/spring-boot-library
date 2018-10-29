package com.example.mylibrary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mylibrary.entity.Message;
import com.example.mylibrary.repository.MessageRepository;

@Service
public class MessageService implements IMessageService {
	@Autowired
	public MessageService(MessageRepository messageRepo) {
		this.messageRepo = messageRepo;
	}
	private MessageRepository messageRepo;
	private static final Logger log = LoggerFactory.getLogger(MessageService.class);

	@Override
	public String saveMessage(String fromName, String fromEmail, String message) {
		log.info("SAVING NEW MESSAGE FROM -> " + fromName + "\n EMAIL ADDRESS -> " + fromEmail + "\n MESSAGE -> " + message);
		
		Message newMessage = new Message();
		newMessage.setFromName(fromName);
		newMessage.setFromEmail(fromEmail);
		newMessage.setMessage(message);
		
		messageRepo.save(newMessage);
		
		return "success";
		
	}

}
