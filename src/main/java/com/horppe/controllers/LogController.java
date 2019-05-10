package com.horppe.controllers;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.horppe.models.Log;
import com.horppe.models.Payload;
import com.horppe.models.User;
import com.horppe.services.LoggerService;
import com.horppe.services.MongoDAL;
import com.horppe.services.UtilService;


@RestController
@RequestMapping("/logs")
public class LogController {
	
	@Autowired
	LoggerService logger;
	
	@Autowired
	MongoDAL mongoDal;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Log> getLogs(@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit,
			@RequestParam(name = "sort", required = false) String sort, 
			@RequestParam(name = "by", required = false) String by){
		
		logger.print("Page: " + page);
		logger.print("Sort: " + sort);
		
		return filterLogsResult(page, limit, sort, by);
	}
	
	@GetMapping("/{userEmail}/")
	public List<Log> getUserLogs(@PathVariable("userEmail") String userEmail,
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "limit", required = false, defaultValue = "5") Integer limit,
			@RequestParam(name = "sort", required = false) String sort, 
			@RequestParam(name = "by", required = false) String by) 
			throws NotFoundException{
		logger.print("Inside getUserLogs");
		User user = mongoDal.userRepository.findByEmail(userEmail);
		logger.print(user);
		
		
		if(user != null) {
			logger.print("user is not null");
			return filterUserResult(page, limit, sort, by, user.getId());
			
		} else {
			logger.print("user is null");
			throw new NotFoundException();
		}
		
	}
	
	private List<Log> filterLogsResult(Integer page, Integer limit, String sort, String by){
		if(page != null) {
			logger.print("Page");
			// limit by page
			Pageable pageAble;
			if(sort != null) {
				if(sort.equalsIgnoreCase("desc")) {
					
					if(by != null) {
						logger.print("With Page and DESC Sort and by");
						Sort bySort = Sort.by(by).descending();
						
						pageAble = PageRequest.of(page, limit, bySort);
						return mongoDal.logRepository.findAll(pageAble).getContent();
					} else {
						logger.print("With Page and DESC Sort Without by");
						Sort bySort = Sort.by("user.id").descending();
						pageAble = PageRequest.of(page, limit, bySort);
						return mongoDal.logRepository.findAll(pageAble).getContent();
					}
				} else {
					if(by != null) {
						logger.print("With Page and ASC Sort and by");
						Sort bySort = Sort.by(by).ascending();
						pageAble = PageRequest.of(page, limit, bySort);
						return mongoDal.logRepository.findAll(pageAble).getContent();
					} else {
						logger.print("With Page and ASC Sort Without by");
						Sort bySort = Sort.by("user.id").descending();
						pageAble = PageRequest.of(page, limit, bySort);
						return mongoDal.logRepository.findAll(pageAble).getContent();
					}
					
				}
				
			} else {
				pageAble = PageRequest.of(page, limit);
				return mongoDal.logRepository.findAll(pageAble).getContent();
			}
			
			
		} else {
			if(sort != null) {
				if(sort.equalsIgnoreCase("desc")) {
					
					if(by != null) {
						logger.print("DESC Sort With by");
						Sort bySort = Sort.by(by).descending();
						
						return mongoDal.logRepository.findAll(bySort);
					} else {
						logger.print("DESC Sort Without by");
						Sort bySort = Sort.by("user.id").descending();
						return mongoDal.logRepository.findAll(bySort);
					}
				} else {
					if(by != null) {
						logger.print("ASC Sort With by");
						Sort bySort = Sort.by(by).ascending();
						return mongoDal.logRepository.findAll(bySort);
					} else {
						logger.print("ASC Sort Without by");
						Sort bySort = Sort.by("user.id").descending();
						return mongoDal.logRepository.findAll(bySort);
					}
					
				}
				
			} else {
				logger.print("Without Page or Sort");
				return mongoDal.logRepository.findAll();
			}
			
		}
		
	}
	
	private List<Log> filterUserResult(Integer page, Integer limit, String sort, String by, String userId){
		
		logger.print("Page: " + page);
		logger.print("Sort: " + sort);
		if(page != null) {
			logger.print("Page");
			// limit by page
			Pageable pageAble;
			if(!sort.equals(null)) {
				
				if(sort.equalsIgnoreCase("desc")) {
					
					if(by != null) {
						logger.print("With Page and DESC Sort and by");
						Sort bySort = Sort.by(by).descending();
						
						pageAble = PageRequest.of(page, limit, bySort);
						return mongoDal.logRepository.findByUserId(userId,pageAble).getContent();
					} else {
						logger.print("With Page and DESC Sort Without by");
						Sort bySort = Sort.by("user.id").descending();
						pageAble = PageRequest.of(page, limit, bySort);
						return mongoDal.logRepository.findByUserId(userId,pageAble).getContent();
					}
				} else {
					if(by != null) {
						logger.print("With Page and ASC Sort and by");
						Sort bySort = Sort.by(by).ascending();
						pageAble = PageRequest.of(page, limit, bySort);
						return mongoDal.logRepository.findByUserId(userId,pageAble).getContent();
					} else {
						logger.print("With Page and ASC Sort Without by");
						Sort bySort = Sort.by("user.id").descending();
						pageAble = PageRequest.of(page, limit, bySort);
						return mongoDal.logRepository.findByUserId(userId,pageAble).getContent();
					}
					
				}
				
			} else {
				pageAble = PageRequest.of(page, limit);
				return mongoDal.logRepository.findByUserId(userId,pageAble).getContent();
			}
			
			
		} else {
			if(sort != null) {
				
				if(sort.equalsIgnoreCase("desc")) {
					
					if(by != null) {
						logger.print("DESC Sort With by");
						Sort bySort = Sort.by(by).descending();
						
						return mongoDal.logRepository.findByUserId(userId,bySort);
					} else {
						logger.print("DESC Sort Without by");
						Sort bySort = Sort.by("user.id").descending();
						return mongoDal.logRepository.findByUserId(userId,bySort);
					}
				} else {
					if(by != null) {
						logger.print("ASC Sort With by");
						Sort bySort = Sort.by(by).ascending();
						return mongoDal.logRepository.findByUserId(userId,bySort);
					} else {
						logger.print("ASC Sort Without by");
						Sort bySort = Sort.by("user.id").descending();
						return mongoDal.logRepository.findByUserId(userId,bySort);
					}
					
				}
				
			} else {
				logger.print("Without Page or Sort");
				return mongoDal.logRepository.findByUserId(userId);
			}
			
		}
		
		
		
	}
	

}
