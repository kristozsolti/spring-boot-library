package com.example.mylibrary.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.mylibrary.entity.Role;
import com.example.mylibrary.entity.User;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1313964810521821102L;
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}
	
	private User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<>();
		Set<Role> roles = user.getRoles();
		
		roles.forEach( 
				role -> authorities.add(
						new SimpleGrantedAuthority(role.getRole())
						)
				);
		
		return authorities;
	}
	
	public Long getUserId() {
		return user.getId();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	// USING EMAIL AS USERNAME BY DESIGN
	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
