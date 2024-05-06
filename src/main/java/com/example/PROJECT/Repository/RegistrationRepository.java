package com.example.PROJECT.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PROJECT.Model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

   
}
