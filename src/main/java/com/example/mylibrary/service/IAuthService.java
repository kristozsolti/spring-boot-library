package com.example.mylibrary.service;

import com.example.mylibrary.entity.User;
import com.example.mylibrary.shared.ResponseMessage;

public interface IAuthService {

	ResponseMessage registerUser(User user);

}
