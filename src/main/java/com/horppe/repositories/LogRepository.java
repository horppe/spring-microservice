package com.horppe.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.horppe.models.Log;


public interface LogRepository extends MongoRepository<Log, String> {

    
    public List<Log> findByUserId(String userId);
    
}
