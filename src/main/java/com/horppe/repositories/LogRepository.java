package com.horppe.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.horppe.models.Log;


public interface LogRepository extends MongoRepository<Log, String> {

    public List<Log> findByUser_Email(String email);
    public List<Log> findByUserId(String id);
    public Page<Log> findByUserId(String id, Pageable page);
    public List<Log> findByUserId(String id, Sort sort);
    
}
