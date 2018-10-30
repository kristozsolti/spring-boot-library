package com.example.mylibrary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// ALLOWING NON-CRYPTED PASSWORDS FOR TESTING ONLY
	@Bean
	 public static NoOpPasswordEncoder passwordEncoder() {
	  return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	 }
	
	// IN MEMORY USERS FOR TESTING ONLY
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user@test.com")
				.password("pwd")
				.roles("USER")
			.and()
				.withUser("admin@test.com")
				.password("pwd")
				.roles("ADMIN")
		;
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
				.antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers(HttpMethod.GET ,"/registration").permitAll()
				
				// ADMIN ZONE
				.antMatchers("/admin/**").hasAuthority("ADMIN")
				
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
