package com.horppe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.horppe.MongoDAL;
import com.horppe.models.Action;
import com.horppe.models.Log;
import com.horppe.models.Payload;
import com.horppe.models.User;
import com.horppe.repositories.UserRepository;
import com.mongodb.DuplicateKeyException;

@Component
public class SeederService {
	@Autowired
	MongoDAL mongoDal;
	
	@Autowired 
	LoggerService logger;
	
	List<String> firstNames = new ArrayList<String>();
	List<String> lastNames = new ArrayList<String>();
	List<String> userTypes = new ArrayList<String>();
	List<Action> actions = new ArrayList<Action>();
	List<User> users = new ArrayList<User>();
	
	public SeederService() {
		super();
		initialize();
	}
	
	
	private void initialize() {
		// First names
		firstNames.add("Alice");
		firstNames.add("Bob");
		firstNames.add("Alex");
		firstNames.add("Jon");
		firstNames.add("Bran");
		firstNames.add("Bobby");
		firstNames.add("Flex");
		firstNames.add("Adewale");
		firstNames.add("John");
		firstNames.add("Stephen");
		
		// Last names
		lastNames.add("Smith");
		lastNames.add("Winter");
		lastNames.add("Box");
		lastNames.add("Snow");
		lastNames.add("Oluokun");
		lastNames.add("Ajayi");
		lastNames.add("Crowther");
		lastNames.add("Adekolu");
		lastNames.add("Olorede");
		
		// User types
		userTypes.add("customer");
		userTypes.add("operation");
		userTypes.add("service");
		
		// Actions
		actions.add(Action.CHARGES);
		actions.add(Action.TRANSFER);
		actions.add(Action.WITHDRAWAL);
		actions.add(Action.LOGIN);
		actions.add(Action.LOGOUT);
		actions.add(Action.PAYMENT);
		actions.add(Action.PURCHASE);
	}
	
	public void seedRandomUsersInDB(int maxLength) {
		logger.print("Seeding Users in DB");
		// First clear the collection
		mongoDal.removeAllUsers();
				
		
		for (int i = 0; i < maxLength; i++) {

			// Get random values
			String fName = getRandomValue(firstNames);
			String lName = getRandomValue(lastNames);
			String uType = getRandomValue(userTypes);
			
			// Create a random user
			User newUser = new User(fName, lName, fName.toLowerCase() + lName.toLowerCase() + "@gmail.com", uType);
			try {
				mongoDal.userRepository.save(newUser);
			} 
			catch(Exception ex) {
				// email is already in db,
				// change it and then save again
				newUser.setEmail(fName.toLowerCase() + lName.toLowerCase() + i + "@gmail.com");
				mongoDal.userRepository.save(newUser);
			}
			users.add(newUser);
		}
		logger.print("Users added to db");
		logger.print(users);
		
	}
	
	public void seedLogsInDB(int userLogs) {
		logger.print("Seeding DB with Logs");
		
		mongoDal.removeAllLogs();
		
		// TODO Handle charges action payload parsing with respect to user types and action types
		users.forEach((user) -> {
			for(int i = 0; i < userLogs; i++) {
				Log newLog = new Log();
				newLog.setAction(getRandomAction());
				newLog.setPayload(getActionPayload(newLog.getAction(), user));
				newLog.setUser(user);
				mongoDal.logRepository.save(newLog);
			}
		});
		
		
		logger.print("Logs Seeded");

	}
	
	private Payload getActionPayload(Action action, User user) {
		switch (action) {
			case PURCHASE: 
				return new Payload(user.getFirstName(), 
						user.getLastName(), 
						user.getEmail(), 
						null, 
						"Mastercard", 
						"12345678910",
						200, 
						"A purchase by " + user.getFirstName() + " " + user.getLastName() );
			case LOGIN: 
				return new Payload(user.getFirstName(), 
						user.getLastName(), 
						user.getEmail(), 
						null, 
						null, 
						null,
						200, 
						"A purchase by " + user.getFirstName() + " " + user.getLastName() );
			case LOGOUT: 
				return new Payload(user.getFirstName(), 
						user.getLastName(), 
						user.getEmail(), 
						null, 
						null,
						null,
						200, 
						"A purchase by " + user.getFirstName() + " " + user.getLastName() );
			case PAYMENT: 
				return new Payload(user.getFirstName(), 
						user.getLastName(), 
						user.getEmail(), 
						null, 
						"Mastercard", 
						"12345678910",
						2000, 
						"A purchase by " + user.getFirstName() + " " + user.getLastName() );
			case TRANSFER: 
				return new Payload(user.getFirstName(), 
						user.getLastName(), 
						user.getEmail(), 
						null, 
						"Mastercard",
						"12345678910",
						5000, 
						"Transfer by " + user.getFirstName() + " " + user.getLastName() );
			case WITHDRAWAL: 
				return new Payload(user.getFirstName(), 
						user.getLastName(), 
						user.getEmail(), 
						null, 
						"Mastercard",
						"12345678910",
						200, 
						"Withdrawal by " + user.getFirstName() + " " + user.getLastName() );
			case CHARGES:
				return new Payload(user.getFirstName(), 
						user.getLastName(), 
						user.getEmail(), 
						null, 
						"Mastercard",
						"12345678910",
						500, 
						"500 Charges Debited from User: " + user.getFirstName() + " " + user.getLastName() );
			default: return null;
		}
	}
	
	private String getRandomValue(List<String> list) {
		int randomIndex = (int) Math.floor(Math.random() * list.size());
		String value = list.get(randomIndex);
		return value;
	}
	
	private Action getRandomAction() {
		int randomIndex = (int) Math.floor(Math.random() * actions.size());
		Action action = actions.get(randomIndex);
		return action;
	}
	
}
