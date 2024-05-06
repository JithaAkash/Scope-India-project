package com.example.PROJECT.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.PROJECT.Model.Contact;

@Service
public class ContactService {

 @Autowired
 private JavaMailSender javaMailSender;

 public void sendContactEmail(Contact contact) {
     try {
         validateContact(contact);

         SimpleMailMessage message = new SimpleMailMessage();
         message.setTo("info@scopeindia.org");
         message.setSubject(contact.getSubject());
         message.setText("From: " + contact.getName() + "\nEmail: " + contact.getEmail() + "\n\n" + contact.getMessage());

         javaMailSender.send(message);
     } catch (MailException | IllegalArgumentException e) {
         
         throw new RuntimeException("Unable to send an email right now. Please try again later.", e);
     }
 }

 private void validateContact(Contact contact) {
     if (contact.getName().isEmpty() || contact.getEmail().isEmpty() ||
             contact.getSubject().isEmpty() || contact.getMessage().isEmpty()) {
         throw new IllegalArgumentException("All fields must be filled");
     }
 }
}

