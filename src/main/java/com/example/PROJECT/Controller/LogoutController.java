package com.example.PROJECT.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {

 @GetMapping("/logout")
 public String logout(HttpServletRequest request, HttpServletResponse response) {
     HttpSession session = request.getSession();
     session.invalidate();


     return "redirect:/login"; 
 }
}

