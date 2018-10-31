package com.example.mylibrary.service;

import java.util.List;

import com.example.mylibrary.entity.User;
import com.example.mylibrary.shared.ResponseMessage;


public interface IUserService {
	
	public User findByEmail(String email);

	public ResponseMessage registerUser(User user);

	public List<User> getAllSimpleUsers();

	public User findById(String userId);

	public List<User> searchUsersByName(String userName);

}
