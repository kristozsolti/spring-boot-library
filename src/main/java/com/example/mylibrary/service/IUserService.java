package com.example.mylibrary.service;

import com.example.mylibrary.entity.User;
import com.example.mylibrary.shared.ResponseMessage;

public interface IUserService {
	
	public User findByEmail(String email);

	public ResponseMessage registerUser(User user);

}
