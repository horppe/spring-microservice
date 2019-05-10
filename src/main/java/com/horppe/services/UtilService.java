package com.horppe.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.horppe.models.Action;
import com.horppe.models.Payload;


public class UtilService {
	
	public UtilService() {
		
	}
	
	public Action getAction(String string) {
		switch (string) {
			case "purchase": 
				return Action.PURCHASE;
			case "login": 
				return Action.LOGIN;
			case "logout": 
				return Action.LOGOUT;
			case "payment": 
				return Action.PAYMENT;
			case "deposit": 
				return Action.TRANSFER;
			case "withdrawal": 
				return Action.WITHDRAWAL;
			case "charges":
				return Action.CHARGES;
			default: return null;
		}
	}
	
	public String getActionString(Action action) {
		switch (action) {
			case PURCHASE: 
				return "purchase";
			case LOGIN: 
				return "login";
			case LOGOUT: 
				return "logout";
			case PAYMENT: 
				return "payment";
			case TRANSFER: 
				return "deposit";
			case WITHDRAWAL: 
				return "withdrawal";
			case CHARGES:
				return "charges";
			default: return null;
		}
	}
	
	
}
