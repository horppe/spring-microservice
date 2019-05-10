package com.horppe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horppe.MongoDAL;
import com.horppe.models.User;

@RestController
@RequestMapping("/user")
public class UserController {
//	@Autowired
	MongoDAL mongoDal;
	
	@GetMapping
	public List<User> getUsers(){
		return mongoDal.userRepository.findAll();
	}
}
