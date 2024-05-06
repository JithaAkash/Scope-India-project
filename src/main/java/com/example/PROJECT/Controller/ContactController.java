package com.example.PROJECT.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.PROJECT.Model.Contact;

@Controller
public class ContactController {

 @Autowired
 private JavaMailSender javaMailSender;

 @GetMapping("/contact")
 public String showContactPage(Model model) {
     model.addAttribute("contact", new Contact());
     return "contact";
 }

 @PostMapping("/sendEmail")
 public String sendEmail(@ModelAttribute Contact contact, Model model) {
     try {
       
         if (contact.getName().isEmpty() || contact.getEmail().isEmpty() ||
                 contact.getSubject().isEmpty() || contact.getMessage().isEmpty()) {
             throw new IllegalArgumentException("All fields must be filled");
         }

        
         sendSimpleMessage(contact);

         model.addAttribute("successMessage", "Your message has been sent successfully!");
     } catch (MailException | IllegalArgumentException e) {
         model.addAttribute("errorMessage", "Unable to send an email right now. Please try again later.");
     }

     return "contact";
 }

 private void sendSimpleMessage(Contact contact) {
     SimpleMailMessage message = new SimpleMailMessage();
     message.setTo("info@scopeindia.org");
     message.setSubject(contact.getSubject());
     message.setText("From: " + contact.getName() + "\nEmail: " + contact.getEmail() + "\n\n" + contact.getMessage());

     javaMailSender.send(message);
 }
}
