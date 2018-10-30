package com.example.mylibrary.service;

import com.example.mylibrary.entity.User;

public interface IUserService {
	
	public User findByEmail(String email);

}
