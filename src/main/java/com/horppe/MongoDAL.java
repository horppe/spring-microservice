package com.horppe;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.horppe.models.*;

@Component
public class MongoDAL {
	
	@Autowired
	public CustomerRepository repository;

	public MongoDAL() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void seed(String... args) {
	//		// First remove data in collection MongoDAL
		try {
//			removeAll();
			//	save a couple of customers
			System.out.println("Printing Repo");
			System.out.println(repository);
//			repository.save(new Customer("Alice", "Smith"));
//			repository.save(new Customer("Bob", "Smith"));
//			System.out.println("Customers successfully added.");
		} catch (Exception e) {
			FirstSpringBootApplication.print("Error occured in seed");
			System.out.println(e.getMessage());
		}
			
	//
	//		// fetch all customers
	//		System.out.println("Customers found with findAll():");
	//		System.out.println("-------------------------------");
	//		for (Customer customer : repository.findAll()) {
	//			System.out.println(customer);
	//		}
	//		System.out.println();
	//
	//		// fetch an individual customer
	//		System.out.println("Customer found with findByFirstName('Alice'):");
	//		System.out.println("--------------------------------");
	//		System.out.println(repository.findByFirstName("Alice"));
	//
	//		System.out.println("Customers found with findByLastName('Smith'):");
	//		System.out.println("--------------------------------");
	//		for (Customer customer : repository.findByLastName("Smith")) {
	//			System.out.println(customer);
	//		}
	
	}
	
	
	
	public void removeAll() {
		repository.deleteAll();
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MongoDAL(Object Active)";
	}

}
