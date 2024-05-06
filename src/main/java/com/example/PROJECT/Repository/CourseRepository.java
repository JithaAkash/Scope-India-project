package com.example.PROJECT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PROJECT.Model.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

   

   
    List<Course> findByCourseName(String courseName);

    
    List<Course> findByDurationLessThan(String duration);

   
}
