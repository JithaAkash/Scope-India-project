package com.example.PROJECT.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.PROJECT.Model.LoginUser;
import com.example.PROJECT.Repository.LoginUserRepository;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void generateAndSendTempPassword(String email) {
        Optional<LoginUser> optionalUser = loginUserRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            LoginUser user = optionalUser.get();
            String tempPassword = generateTempPassword();
            user.setTempPassword(passwordEncoder.encode(tempPassword));
            user.setFirstTimeLogin(true);

            loginUserRepository.save(user);

            sendTempPasswordEmail(user.getEmail(), tempPassword);
        } else {
          
        }
    }

    private String generateTempPassword() {
        
        return "generatedTempPassword";
    }

    private void sendTempPasswordEmail(String email, String tempPassword) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Temporary Password");
            message.setText("Your temporary password is: " + tempPassword);

            javaMailSender.send(message);
        } catch (MailException e) {
            
            throw new RuntimeException("Unable to send an email right now. Please try again later.", e);
        }
    }

    public void resetPassword(String email, String newPassword) {
        Optional<LoginUser> optionalUser = loginUserRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            LoginUser user = optionalUser.get();
            user.setPassword(passwordEncoder.encode(newPassword));
            user.setTempPassword(null);
            user.setFirstTimeLogin(false);

            loginUserRepository.save(user);
        } else {
            
        }
    }

    public boolean verifyLogin(String email, String password) {
        Optional<LoginUser> optionalUser = loginUserRepository.findByEmail(email);

        return optionalUser.map(user -> passwordEncoder.matches(password, user.getPassword())).orElse(false);
    }

    public boolean isFirstTimeLogin(String email) {
        Optional<LoginUser> optionalUser = loginUserRepository.findByEmail(email);
        return optionalUser.map(LoginUser::isFirstTimeLogin).orElse(false);
    }

    
}
