//package com.example.PROJECT.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.PROJECT.Model.UserProfile;
//import com.example.PROJECT.Repository.UserProfileRepository;
//
//@Service
//public class ProfileService {
//
//    @Autowired
//    private UserProfileRepository userProfileRepository;
//
//    public UserProfile getUserProfileByUsername(String username) {
//        return userProfileRepository.findByUsername(username);
//    }
//
//    public UserProfile saveUserProfile(UserProfile userProfile) {
//        return userProfileRepository.save(userProfile);
//    }
//}
