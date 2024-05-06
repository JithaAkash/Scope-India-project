package com.example.PROJECT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.PROJECT.Service.LoginService;


@Controller
public class LoginController {

 @Autowired
 private LoginService loginService;

 @GetMapping("/login")
 public String showLoginPage() {
     return "login";
 }

 @PostMapping("/login")
 public String login(@RequestParam String email, @RequestParam String password, 
                     @RequestParam(name = "keepLoggedIn", defaultValue = "false") boolean keepLoggedIn) {
    
     return "redirect:/studentdashboard";
 }

 @GetMapping("/generateTempPassword")
 public String generateTempPassword(@RequestParam String email) {
     loginService.generateAndSendTempPassword(email);
     return "redirect:/login";
 }
}


