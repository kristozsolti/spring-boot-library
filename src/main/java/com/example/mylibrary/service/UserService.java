package com.example.mylibrary.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mylibrary.entity.Role;
import com.example.mylibrary.entity.User;
import com.example.mylibrary.repository.RoleRepository;
import com.example.mylibrary.repository.UserRepository;
import com.example.mylibrary.shared.ResponseMessage;

@Service
public class UserService implements IUserService, UserDetailsService {
	@Autowired
	public UserService(UserRepository userRepo, RoleRepository roleRepo){
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}
	private UserRepository userRepo;
	private RoleRepository roleRepo;
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	private final String USER_ROLE = "USER";
//	private final String ADMIN_ROLE = "ADMIN";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("SIGN IN ATTEMPT -> " + username);
		User user = findByEmail(username);
		if( user == null ){
			log.error("USER WITH USERNAME -> " + username + " NOT FOUND!");
			throw new UsernameNotFoundException(username);
		}
		
		return new UserDetailsImpl(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public ResponseMessage registerUser(User user) {
		
		// If the user somehow is not correct, return error message
		if (user == null) {
			log.error("USER REGISTRATION FAILED -> USER IS NULL!");
			return ResponseMessage.error;
		}
		
		// If the user is already exists, return error message
		if(userRepo.findByEmail(user.getEmail()) != null) {
			log.error("USER REGISTRATION FAILED -> USER ALREADY EXISTS!");
			return ResponseMessage.error;
		}
		
		// Dealing with user role
		Role userRole = roleRepo.findByRole(USER_ROLE);
		if(userRole != null) {
			user.getRoles().add(userRole);
		} else {
			user.addRoles(USER_ROLE);
		}
		// Hashing the password
		String password = user.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		user.setPassword(hashedPassword);
		
		userRepo.save(user);
		log.info("NEW USER IS REGISTERED -> " + user);
		return ResponseMessage.success;
	}

	@Override
	public List<User> getAllSimpleUsers() {
		List<User> simpleUsers = userRepo.findAllUsersByRole(USER_ROLE);
		log.info("GET ALL USERS WITH 'USER' ROLE -> " + simpleUsers);
		
		return simpleUsers;
	}

	@Override
	public User findById(String userId) {
		log.info("GET USER WITH ID -> " + userId);
		Long id = Long.parseLong(userId);
		User user = userRepo.findById(id).get();
		log.info("USER FOUND-> " + user);
		
		return user;
	}

	@Override
	public List<User> searchUsersByName(String userName) {
		// Input username has to be lowercase in order to search could be case insensitive
		List<User> usersFound = userRepo.findAllByFullNameContainingIgnoreCase(userName.toLowerCase());
		log.info("SEARCH USERS WITH NAME -> " + userName + " FOUND " + usersFound.size());
		return usersFound;
	}

}
