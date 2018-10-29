package com.example.mylibrary.service;

import com.example.mylibrary.shared.ResponseMessage;

public interface IContactMessageService {

	public ResponseMessage saveMessage(String fromName, String fromEmail, String message);
	
}
