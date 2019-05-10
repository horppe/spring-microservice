package com.horppe.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "logs")
public class Log {

    @Id
    public String id;
    
    @DBRef
    public User user;
    
    public Action action;
    
    public Payload payload;
    
    public Date createdAt;

    public Log() {}

  

	public Log(Action action, Payload payload) {
		super();
		this.action = action;
		this.payload = payload;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}
	
	

	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	@Override
    public String toString() {
        return String.format(
                "Log[id=%s, action=%s, payload='%s']",
                id, action, payload);
    }

}
