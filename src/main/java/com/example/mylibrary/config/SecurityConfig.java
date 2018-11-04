package com.example.mylibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String ADMIN_ROLE = "ADMIN";

	// ALLOWING NON-CRYPTED PASSWORDS FOR TESTING ONLY
	@Bean
	 public static NoOpPasswordEncoder passwordEncoder() {
	  return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	 }
	
	// ALLOWING STATIC RESOURCES
	@Override
	public void configure(WebSecurity web) {
	    web
	    	.ignoring()
	    		.antMatchers("/css/**", "/js/**", "/img/**");
	}
	
	// ACCESS CONFIGURATION
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// FOR TESTING ONLY -- ACCESS H2 DB
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		http
			.authorizeRequests()
			
				// PUBLIC ZONE
					// Index
				.antMatchers(HttpMethod.GET, "/").permitAll()
					// Browse and search BOOKS
				.antMatchers(HttpMethod.GET, "/books").permitAll()
				.antMatchers(HttpMethod.GET, "/books/{\\d+}").permitAll()
				.antMatchers(HttpMethod.GET, "/books/search").permitAll()
					// Browse and search AUTHORS
				.antMatchers(HttpMethod.GET, "/authors").permitAll()
				.antMatchers(HttpMethod.GET, "/authors/{\\d+}").permitAll()
				.antMatchers(HttpMethod.GET, "/authors/search").permitAll()
					// Contact page and contact message
				.antMatchers(HttpMethod.GET, "/contact").permitAll()
				.antMatchers(HttpMethod.POST, "/save-message").permitAll()
					// Registration form
				.antMatchers(HttpMethod.GET ,"/registration").permitAll()
				.antMatchers(HttpMethod.POST, "/register").permitAll()
				
				// USER ZONE
					// USERS
				.antMatchers(HttpMethod.GET ,"/user").authenticated()
				.antMatchers(HttpMethod.GET ,"/users").authenticated()
				.antMatchers(HttpMethod.GET ,"/users/search").authenticated()
				
				// ADMIN ZONE
				.antMatchers("/admin/**").hasAuthority(ADMIN_ROLE)
				.antMatchers(HttpMethod.GET, "/books/add-new").hasAuthority(ADMIN_ROLE)
				.antMatchers(HttpMethod.GET, "/authors/add-new").hasAuthority(ADMIN_ROLE)
				.antMatchers(HttpMethod.POST, "/books/add-new").hasAuthority(ADMIN_ROLE)
				.antMatchers(HttpMethod.POST, "/authors/add-new").hasAuthority(ADMIN_ROLE)
				
				.anyRequest().authenticated()
			.and()
				// LOGIN PAGE
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/")
					.failureUrl("/login?error")
					.permitAll()
			.and()
				// LOGOUT
				.logout()
					.logoutSuccessUrl("/login?logout")
					.permitAll()
			;
	} 
	
	
//	@Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
	
}
