package com.example.PROJECT.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PROJECT.Model.Registration;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    
}

