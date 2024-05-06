package com.example.PROJECT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PROJECT.Model.LoginUser;

import java.util.Optional;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {

 Optional<LoginUser> findByEmail(String email);
}
