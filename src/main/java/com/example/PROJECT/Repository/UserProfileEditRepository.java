package com.example.PROJECT.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PROJECT.Model.UserProfileEdit;

public interface UserProfileEditRepository extends JpaRepository<UserProfileEdit, Long> {
    UserProfileEdit findByUsername(String username);
    
}

