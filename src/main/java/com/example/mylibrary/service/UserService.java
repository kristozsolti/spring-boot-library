package com.example.mylibrary.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.mylibrary.entity.User;
import com.example.mylibrary.entity.UserInfo;
import com.example.mylibrary.repository.UserRepository;
import com.example.mylibrary.shared.Roles;

@Service
public class UserService implements IUserService {
	@Autowired
	public UserService(UserRepository userRepo){
		this.userRepo = userRepo;
	}
	private UserRepository userRepo;

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	private static final String USER_ROLE = Roles.USER.toString();

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	@Override
	public List<User> getAllSimpleUsers() {
		List<User> simpleUsers = userRepo.findAllUsersByRole(USER_ROLE);
		log.info("GET ALL USERS WITH 'USER' ROLE -> " + simpleUsers);
		
		return simpleUsers;
	}

	@Override
	public User findById(Long userId) {
		log.info("GET USER WITH ID -> " + userId);
		User user = userRepo.findById(userId).get();
		log.info("USER FOUND-> " + user);
		
		return user;
	}

	@Override
	public List<User> searchUsersByName(String userName) {
//		 Input username has to be lowercase in order to search could be case insensitive
		List<User> usersFound = userRepo.findAllByUserInfoFullNameContainingIgnoreCase(userName.toLowerCase());
		log.info("SEARCH USERS WITH NAME -> " + userName + " FOUND " + usersFound.size());
		return usersFound;
	}

	@Override
	public User getAuthenticatedUser() {
		Long userId = getAuthenticatedUserId();
		
		User authenticatedUser = userRepo.findById(userId).get();
		
		log.info("GET AUTHENTICATED USER -> " + authenticatedUser);
		
		return authenticatedUser;
	}

	@Override
	public UserInfo getAuthenticatedUserInfo() {
		UserInfo userInfo = getAuthenticatedUser().getUserInfo();
		return userInfo;
	}
	
	@Override
	public void saveUserInfo(UserInfo userInfo) {
		User authenticatedUser = getAuthenticatedUser();
		userInfo.setUser(authenticatedUser);
		authenticatedUser.setUserInfo(userInfo);
		log.debug("!!! SAVING USER SETTINGS -> " + userInfo + authenticatedUser);
		userRepo.save(authenticatedUser);
	}
	
	private Long getAuthenticatedUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserAuthDetailsImpl userDetails = (UserAuthDetailsImpl) auth.getPrincipal();
		
		Long userId = userDetails.getUserId();
		
		return userId;
	}

}
