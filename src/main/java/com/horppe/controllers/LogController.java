package com.horppe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.horppe.MongoDAL;
import com.horppe.models.Log;
import com.horppe.models.Payload;
import com.horppe.models.User;
import com.horppe.services.LoggerService;
import com.horppe.services.UtilService;


@RestController
@RequestMapping("/log")
public class LogController {
//	@Autowired
	UtilService utilService;
	
//	@Autowired
	LoggerService logger;
	
//	@Autowired
	MongoDAL mongoDal;
	
	@GetMapping
	public List<Log> getLogs(){
		return mongoDal.logRepository.findAll();
	}
	
	@GetMapping("{userEmail}")
	public List<Log> getUserLogs(@PathVariable("userEmail") String userEmail) throws NotFoundException{
		User user = mongoDal.userRepository.findByEmail(userEmail);
		if(user != null) {
			return mongoDal.logRepository.findByUserId(user.getId());
		} else {
			throw new NotFoundException();
		}
		
	}
	
	@PostMapping
	public String addLog(@RequestParam("action") String action, 
			Payload payload, @RequestParam("userEmail") String userEmail) {
		
		logger.print("In Add Log, Printing payload");
		logger.print(payload);
		
		Log newLog = new Log();
		newLog.setAction(utilService.getAction(action));
		newLog.setPayload(payload);
		
		return "Tested";
		
//		User user;
//		try {
//			user = mongoDal.userRepository.findByEmail(userEmail);
//			if(user == null) {
//				System.out.println("User is null");
//			} else {
//				newLog.setUser(user);
//				// TODO 
//			}
//		}
//		catch(Exception ex) {
//			user = new User();
//			user.setFirstName("Random First Name");
//			user.setLastName("Random Last Name");
//			user.setType("operations");
//		}
//		
//		return "Log added";
	}
}
