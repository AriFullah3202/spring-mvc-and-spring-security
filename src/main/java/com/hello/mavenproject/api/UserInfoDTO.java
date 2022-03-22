package com.hello.mavenproject.api;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserInfoDTO {
	
	
	private int id;
	@NotEmpty(message =" * user name can not be null")
	private String userName;
	@Size(min = 8 ,message ="* password should be at least 8 character")
    private String password;
	@Email
    private String email;
	@NotEmpty(message ="* first name can not be empty")
    private String firstName;
	@NotEmpty(message="* last name can not be empty")
    private String lastName;
	
	
	
	
	
	public UserInfoDTO() {
		super();
	}
	public UserInfoDTO(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	@Override
	public String toString() {
		return "UserInfoDTO [userName=" + userName + ", password=" + password + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

    
}
