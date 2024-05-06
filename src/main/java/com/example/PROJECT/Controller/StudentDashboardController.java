package com.example.PROJECT.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.PROJECT.Model.Course;

@Controller
@RequestMapping("/studentdashboard")
public class StudentDashboardController {

    @Autowired
    private StudentDashboardService studentDashboardService;

    @GetMapping("/searchcourses")
    public String searchCourses(Model model) {
        List<Course> allCourses = studentDashboardService.getAllCourses();
        model.addAttribute("courses", allCourses);
        return "searchcourses";
    }

    @GetMapping("/signup/{courseId}")
    public String signUpForCourse(@PathVariable Long courseId) {
       

        return "redirect:/studentdashboard/searchcourses";
    }

    @GetMapping("/signedupcourses")
    public String showSignedUpCourses(Model model) {
        
        List<Course> signedUpCourses = studentDashboardService.getSignedUpCourses();
        model.addAttribute("signedUpCourses", signedUpCourses);

        return "signedupcourses";
    }

   
}


