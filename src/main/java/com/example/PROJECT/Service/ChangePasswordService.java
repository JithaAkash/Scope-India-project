package com.example.PROJECT.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PROJECT.Model.ChangePassword;
import com.example.PROJECT.Repository.ChangePasswordRepository;

@Service
public class ChangePasswordService {

 @Autowired
 private ChangePasswordRepository changePasswordRepository;

 public ChangePassword findByUsername(String username) {
     return changePasswordRepository.findByUsername(username);
 }

 public ChangePassword saveChangePassword(ChangePassword changePassword) {
     return changePasswordRepository.save(changePassword);
 }
}
