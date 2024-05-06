package com.example.PROJECT.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.PROJECT.Model.UserProfileEdit;
import com.example.PROJECT.Service.UserProfileEditService;

@Controller
@RequestMapping("/profile")
public class UserProfileEditController {

    @Autowired
    private UserProfileEditService userProfileEditService;

    @GetMapping("/edit")
    public String showEditProfilePage(Model model, Authentication authentication) {

        String currentUsername = authentication.getName();

       
        UserProfileEdit userProfileEdit = userProfileEditService.getUserProfileEditByUsername(currentUsername);

        if (userProfileEdit == null) {
            
            return "error";
        }

        model.addAttribute("profile", userProfileEdit);
        return "profile/edit";
    }
}

