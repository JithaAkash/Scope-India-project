package com.example.PROJECT.Service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PROJECT.Model.Course;
import com.example.PROJECT.Repository.CourseRepository;

@Service
public class StudentDashboardService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void signUpForCourse(Long courseId) {
       
    }

    public List<Course> getSignedUpCourses(Long studentId) {
      
        return Collections.emptyList(); 
    }

    

}

