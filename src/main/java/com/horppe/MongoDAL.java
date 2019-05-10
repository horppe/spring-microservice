package com.horppe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.horppe.models.*;
import com.horppe.repositories.*;

@Component
public class MongoDAL {
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public LogRepository logRepository;

	public MongoDAL() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void removeAll() {
		userRepository.deleteAll();
		logRepository.deleteAll();
		
	}
	public void removeAllUsers() {
		userRepository.deleteAll();		
	}
	
	public void removeAllLogs() {
		logRepository.deleteAll();
	}
	public void addUser(User user) {
		userRepository.save(user);
	}
	public void addLog(Log log) {
		logRepository.save(log);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MongoDAL(Object Active)";
	}

}
