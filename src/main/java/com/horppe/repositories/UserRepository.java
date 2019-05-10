package com.horppe.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.horppe.models.User;


public interface UserRepository extends MongoRepository<User, String> {

    public List<User> findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public User findByEmail(String email);

    public List<User> findByType(String type);
    
}
