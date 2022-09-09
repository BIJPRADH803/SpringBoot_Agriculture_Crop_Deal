package com.aglcropsystem.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Farmerslist")
public class Farmer {
	

	@Id
	private String farmerId;
	
	@NotNull(message = "First name should not be empty")
	@Size(min = 2, message = "First name should not be less than 2 characters")
	private String firstName;
	
	@NotNull(message = "Last name should not be empty")
	@Size(min = 2, message = "Last name should not be less than 2 characters")
	private String lastName;
	
	@Pattern(regexp = "\\d{10}", message = "Invalid contact details")
	private String phoneNumber;
	
	
	@NotNull(message = "Username should not be empty")
	@Size(min = 2, message = "Username should not be less than 2 characters")
	private String username;
	
	@NotNull(message = "Password should not be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password Should contain:\n1)a digit must occur at least once\n 2)a lower case letter must occur at least once\n\r\n 3)an upper case letter must occur at least once\n4)a special character must occur at least once\n\r\n5)no whitespace allowed in the entire string\n6)at least 8 characters")
	private String password;
	
	@NotNull(message = "Email should not be empty")
	@Email(message = "Invalid E-mail Id")
	private String email;
	
	@NotNull(message = "location should not be empty")
	private String location;
	
	@NotNull(message = "which bank u must be select")
	private String bank;
	
	@NotNull(message = "Account no should not be empty")
	private String accountNo;
	
	@NotNull(message = "bank branch should not be empty")
	private String bankbranch;
	
	
    private String about;
    
 
    
    // private List<Crops> crops;
    
	
	public Farmer() {

	
}

public Farmer(String farmerId, String firstName, String lastName, String username, String password, String email,
		String phoneNumber, String location, String bank, String accountNo, String bankbranch, String about) {
	super();
	this.farmerId = farmerId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
	this.password = password;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.location = location;
	this.bank = bank;
	this.accountNo = accountNo;
	this.bankbranch = bankbranch;
	this.about = about;
}

public String getFarmerId() {
	return farmerId;
}

public void setFarmerId(String farmerId) {
	this.farmerId = farmerId;
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

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getBank() {
	return bank;
}

public void setBank(String bank) {
	this.bank = bank;
}

public String getAccountNo() {
	return accountNo;
}

public void setAccountNo(String accountNo) {
	this.accountNo = accountNo;
}

public String getBankbranch() {
	return bankbranch;
}

public void setBankbranch(String bankbranch) {
	this.bankbranch = bankbranch;
}

public String getAbout() {
	return about;
}

public void setAbout(String about) {
	this.about = about;
}

@Override
public String toString() {
	return "Farmer [farmerId=" + farmerId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
			+ username + ", password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber + ", location="
			+ location + ", bank=" + bank + ", accountNo=" + accountNo + ", bankbranch=" + bankbranch + ", about="
			+ about + "]";
}


	

}
