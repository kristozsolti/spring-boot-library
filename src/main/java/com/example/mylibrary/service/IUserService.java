package com.example.mylibrary.service;

import java.util.List;

import com.example.mylibrary.entity.User;
import com.example.mylibrary.entity.UserInfo;


public interface IUserService {
	
	public User findByEmail(String email);

	public List<User> getAllSimpleUsers();

	public User findById(Long userId);

	public List<User> searchUsersByName(String userName);

	public User getAuthenticatedUser();
	
	public UserInfo getAuthenticatedUserInfo();

	public void saveUserInfo(UserInfo userInfo);

}
