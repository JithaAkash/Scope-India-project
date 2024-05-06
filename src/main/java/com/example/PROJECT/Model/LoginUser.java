package com.example.PROJECT.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoginUser {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String email;
 private String password; 
 private String tempPassword;
 private boolean firstTimeLogin;
 
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
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
public String getTempPassword() {
	return tempPassword;
}
public void setTempPassword(String tempPassword) {
	this.tempPassword = tempPassword;
}
public boolean isFirstTimeLogin() {
	return firstTimeLogin;
}
public void setFirstTimeLogin(boolean firstTimeLogin) {
	this.firstTimeLogin = firstTimeLogin;
}
 
 
}
