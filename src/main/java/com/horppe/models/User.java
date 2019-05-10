package com.horppe.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    
    @Indexed(unique = true)
    private String email;
    
	private String type;
	
	public User(String firstName, String lastName, String email, String type) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.type = type;
	}
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public User() {}
	
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName='%s',lastName='%s', email='%s' type='%s']",
                id, firstName, lastName, email, type);
    }

}
