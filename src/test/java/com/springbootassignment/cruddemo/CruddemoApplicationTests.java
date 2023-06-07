package com.springbootassignment.cruddemo;

import com.springbootassignment.cruddemo.entity.Course;
import com.springbootassignment.cruddemo.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CruddemoApplicationTests {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void contextLoads() {
        // This test ensures that the Spring application context is successfully loaded
    }

    @Test
    void testCreateCourse() {
        // Test creating a new course and verify it is successfully saved in the repository
        Course course = new Course();
        course.setTitle("Spring");
        courseRepository.save(course);

        Course savedCourse = courseRepository.findById(course.getId()).orElse(null);
        Assertions.assertNotNull(savedCourse);
        Assertions.assertEquals(course.getTitle(), savedCourse.getTitle());
    }






}
