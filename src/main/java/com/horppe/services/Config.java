package com.horppe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	
}
