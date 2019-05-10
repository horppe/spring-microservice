package com.horppe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import com.horppe.services.LoggerService;
import com.horppe.services.SeederService;


@SpringBootApplication 
public class FirstSpringBootApplication implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired SeederService seeder;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		System.out.println("Application Started");
		
		seeder.seedRandomUsersInDB(50);
		seeder.seedLogsInDB(5);
	}
}
