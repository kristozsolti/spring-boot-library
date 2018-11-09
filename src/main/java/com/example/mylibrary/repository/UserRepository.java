package com.example.mylibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mylibrary.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	public User findByEmail(String email);
	
	public List<User> findAll();
	
	@Query(value = "SELECT u FROM User u JOIN u.roles r ON r.role = ?1")
	public List<User> findAllUsersByRole(String role);

	// Have to ignore ADMIN from the result list
	@Query(value = "SELECT u "
			+ "FROM User u "
			+ "JOIN u.roles r ON r.role = 'USER' "
			+ "JOIN u.userInfo ui ON ui.user = u "
			+ "AND lower(ui.fullName) LIKE %?1%")
	public List<User> findAllByUserInfoFullNameContainingIgnoreCase(String userName);

}
