package com.example.PROJECT.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Registration {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String firstname;
 private String lastname;
 private String gender;
 private Date dateofbirth;
 private String email;
 private String phone;
 private Long country;
 private Long state;
 private Long city;
 private String[] hobby;
 
 public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Date getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(Date dateofbirth) {
	this.dateofbirth = dateofbirth;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Long getCountry() {
	return country;
}
public void setCountry(Long country) {
	this.country = country;
}
public Long getState() {
	return state;
}
public void setState(Long state) {
	this.state = state;
}
public Long getCity() {
	return city;
}
public void setCity(Long city) {
	this.city = city;
}
public String[] getHobby() {
	return hobby;
}
public void setHobby(String[] hobby) {
	this.hobby = hobby;
}
public String getAvatar() {
	return avatar;
}
public void setAvatar(String avatar) {
	this.avatar = avatar;
}
private String avatar;


}
