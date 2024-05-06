package com.example.PROJECT.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PROJECT.Model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    UserProfile findByUsername(String username);

   
}

