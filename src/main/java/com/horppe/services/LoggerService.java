package com.horppe.services;

import org.springframework.stereotype.Service;


public class LoggerService {
	public LoggerService() {}
	
	public void print(String str, String fmt) {
		System.out.println(String.format(fmt, str));
	}
	
	public void print(String str) {
		System.out.println(str);
	}
	
	public void print(Object obj) {
		System.out.println(obj);
	}

}
