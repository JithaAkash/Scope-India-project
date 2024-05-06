package com.example.PROJECT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.PROJECT.Model.UserProfile; 
import com.example.PROJECT.Service.UserProfileService;  

@Controller
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;  

    @GetMapping("/view")
    public String showViewProfilePage(Model model, Authentication authentication) {
       
        String currentUsername = authentication.getName();

       
        UserProfile userProfile = userProfileService.getUserProfileByUsername(currentUsername);

        if (userProfile == null) {
           
            return "error";
        }

        model.addAttribute("profile", userProfile);
        return "profile/view";
    }
}


