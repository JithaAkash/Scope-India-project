package com.example.PROJECT.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PROJECT.Model.UserProfileEdit;
import com.example.PROJECT.Repository.UserProfileEditRepository;

@Service
public class UserProfileEditService {

    @Autowired
    private UserProfileEditRepository userProfileEditRepository;

    public UserProfileEdit getUserProfileEditByUsername(String username) {
        return userProfileEditRepository.findByUsername(username);
    }

    public UserProfileEdit saveUserProfileEdit(UserProfileEdit userProfileEdit) {
        return userProfileEditRepository.save(userProfileEdit);
    }
}

