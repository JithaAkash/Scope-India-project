package com.example.PROJECT.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PROJECT.Model.UserProfile;
import com.example.PROJECT.Repository.UserProfileRepository;


@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile getUserProfileById(Long userProfileId) {
        return userProfileRepository.findById(userProfileId).orElse(null);
    }

    public UserProfile getUserProfileByUsername(String username) {
        return userProfileRepository.findByUsername(username);
    }

    public UserProfile saveUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
}

