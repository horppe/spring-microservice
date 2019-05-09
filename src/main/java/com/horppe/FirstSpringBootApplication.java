package com.horppe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@SpringBootApplication 
public class FirstSpringBootApplication implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired
	private MongoDAL mongoDal;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		print("Application is started");
		print("Printing MongoDAL Object");
		print(mongoDal.toString());
		print("Clearing Mongo Documents");
		// mongoDal.removeAll();
		mongoDal.seed();
	}
	
	public static void print(String str, String fmt) {
		System.out.println(String.format(fmt, str));
	}
	
	public static void print(String str) {
		System.out.println(str);
	}

}
