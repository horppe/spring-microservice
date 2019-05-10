package com.horppe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {

	@Bean
	public LoggerService getLogService() {
		return new LoggerService();
	}
	@Bean
	public UtilService getUtility() {
		return new UtilService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public BCrypt passwordDecoder() {
//		BCrypt.
//	    return new BCryptPasswordEncoder();
//	}
	
}
