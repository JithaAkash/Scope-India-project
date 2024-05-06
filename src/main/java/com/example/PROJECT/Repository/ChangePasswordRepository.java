package com.example.PROJECT.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PROJECT.Model.ChangePassword;

public interface ChangePasswordRepository extends JpaRepository<ChangePassword, Long> {
 ChangePassword findByUsername(String username);
}

