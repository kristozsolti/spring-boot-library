package com.example.mylibrary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mylibrary.entity.Role;
import com.example.mylibrary.entity.User;
import com.example.mylibrary.repository.RoleRepository;
import com.example.mylibrary.repository.UserRepository;
import com.example.mylibrary.shared.ResponseMessage;

@Service
public class UserService implements IUserService, UserDetailsService {
	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepo){
		this.userRepository = userRepository;
		this.roleRepo = roleRepo;
	}
	private UserRepository userRepository;
	private RoleRepository roleRepo;
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	private final String USER_ROLE = "USER";

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
		return userRepository.findByEmail(email);
	}

	@Override
	public ResponseMessage registerUser(User user) {
		
		// If the user somehow is not correct, return error message
		if (user == null) {
			log.error("USER REGISTRATION FAILED -> USER IS NULL!");
			return ResponseMessage.error;
		}
		
		// If the user is already exists, return error message
		if(userRepository.findByEmail(user.getEmail()) != null) {
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
		
		userRepository.save(user);
		log.info("NEW USER IS REGISTERED -> " + user);
		return ResponseMessage.success;
	}

}
