package com.example.mylibrary.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mylibrary.entity.ContactMessage;
import com.example.mylibrary.repository.ContactMessageRepository;
import com.example.mylibrary.shared.ResponseMessage;

@Service
public class ContactMessageService implements IContactMessageService {
	@Autowired
	public ContactMessageService(ContactMessageRepository messageRepo) {
		this.messageRepo = messageRepo;
	}
	private ContactMessageRepository messageRepo;
	private static final Logger log = LoggerFactory.getLogger(ContactMessageService.class);

	@Override
	public ResponseMessage saveMessage(ContactMessage message) {
		
		message.setArrivalDate(new Date());
		
		log.info("SAVING NEW MESSAGE -> " + message.toString());
		messageRepo.save(message);
		
		return ResponseMessage.success;
		
	}

	@Override
	public List<ContactMessage> getAllMessages() {
		List<ContactMessage> messages = messageRepo.findAllByIsDeletedFalseOrderByArrivalDateDesc();
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

	@Override
	public void deleteContactMessageById(Long msgId) {
		ContactMessage message = getMessageById(msgId);
		log.info("SET IS_DELETED TRUE ON MESSAGE -> " + message);
		message.setIsDeleted(true);
		messageRepo.save(message);
	}

}
