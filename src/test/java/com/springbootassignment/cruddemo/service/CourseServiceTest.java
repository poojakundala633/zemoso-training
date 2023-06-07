package com.springbootassignment.cruddemo.service;

import com.springbootassignment.cruddemo.entity.Course;
import com.springbootassignment.cruddemo.repository.CourseRepository;
import com.springbootassignment.cruddemo.service.CourseService;
import com.springbootassignment.cruddemo.service.CourseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }





    @Test
    void findById_WithExistingId_ShouldReturnCourse() {
        // Arrange
        int courseId = 1;
        Course course = new Course(courseId, "Course 1");

        when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));

        // Act
        Course result = courseService.findById(courseId);

        // Assert
        assertEquals(course, result);
        verify(courseRepository).findById(courseId);
    }



    @Test
    void save_ShouldSaveCourse() {
        // Arrange
        Course course = new Course(1, "Course 1");

        // Act
        courseService.save(course);

        // Assert
        verify(courseRepository).save(course);
    }

    @Test
    void deleteById_ShouldDeleteCourse() {
        // Arrange
        int courseId = 1;

        // Act
        courseService.deleteById(courseId);

        // Assert
        verify(courseRepository).deleteById(courseId);
    }

    @Test
    void findByIdIn_ShouldReturnListOfCourses() {
        // Arrange
        List<Integer> courseIds = List.of(1, 2, 3);
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1, "Course 1"));
        courses.add(new Course(2, "Course 2"));

        when(courseRepository.findByIdIn(courseIds)).thenReturn(courses);

        // Act
        List<Course> result = courseService.findByIdIn(courseIds);

        // Assert
        assertEquals(courses, result);
        verify(courseRepository).findByIdIn(courseIds);
    }
}
