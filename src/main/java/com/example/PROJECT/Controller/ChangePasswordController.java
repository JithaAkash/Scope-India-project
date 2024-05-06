package com.example.PROJECT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.PROJECT.Model.ChangePassword;
import com.example.PROJECT.Service.ChangePasswordService;

@Controller
public class ChangePasswordController {

 @Autowired
 private ChangePasswordService changePasswordService;

 @GetMapping("/changepassword")
 public String showChangePasswordForm(Model model) {
     model.addAttribute("changePassword", new ChangePassword());
     return "changepassword";
 }

 @PostMapping("/changepassword")
 public String changePassword(ChangePassword changePassword) {
 
     changePasswordService.saveChangePassword(changePassword);
     return "redirect:/logout";
 }
}
