package com.example.mylibrary.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mylibrary.entity.Role;
import com.example.mylibrary.entity.User;
import com.example.mylibrary.entity.UserInfo;
import com.example.mylibrary.repository.RoleRepository;
import com.example.mylibrary.repository.UserRepository;
import com.example.mylibrary.shared.ResponseMessage;
import com.example.mylibrary.shared.Roles;

@Service
public class AuthService implements IAuthService, UserDetailsService {
	@Autowired
	public AuthService(UserRepository userRepo, RoleRepository roleRepo) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}
	private UserRepository userRepo;
	private RoleRepository roleRepo;
	
	private static final Logger log = LoggerFactory.getLogger(AuthService.class);
	private static final String USER_ROLE = Roles.USER.toString();
	
	@Value("${user.default.avatar}")
	private String DEFAULT_USER_AVATAR;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("SIGN IN ATTEMPT -> " + username);
		User user = userRepo.findByEmail(username);
		if( user == null ){
			log.error("USER WITH USERNAME -> " + username + " NOT FOUND!");
			throw new UsernameNotFoundException(username);
		}
		
		return new UserAuthDetailsImpl(user);
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
		
		// Add a new, default UserInfo to user
		UserInfo userInfo = new UserInfo();
		userInfo.setJoined(new Date());
		userInfo.setAvatarImg(DEFAULT_USER_AVATAR);
		userInfo.setUser(user);
		
		user.setUserInfo(userInfo);
		
		userRepo.save(user);
		log.info("NEW USER IS REGISTERED -> " + user);
		return ResponseMessage.success;
	}

}
