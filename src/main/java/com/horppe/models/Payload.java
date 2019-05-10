package com.horppe.models;

import javax.validation.constraints.NotNull;

public class Payload {
	
	String firstName;
	String lastName;
	
	@NotNull
	String email;
	String password;
	
	String cardType;
	String cardNumber;
	Integer amount;
	
	String description;
	
	
	public Payload(String firstName, String lastName, String email, String password, String cardType, String cardNumber,
			int amount, String description) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.amount = amount;
		this.description = description;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payload [firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", cardType=" + cardType + ", cardNumber=" + cardNumber
				+ ", amount=" + amount + ", description=" + description + "]";
	}
	
	
	
}
