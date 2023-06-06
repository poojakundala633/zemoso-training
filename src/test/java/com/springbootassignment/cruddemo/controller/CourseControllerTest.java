package com.springbootassignment.cruddemo.controller;

import com.springbootassignment.cruddemo.controller.CourseController;
import com.springbootassignment.cruddemo.entity.Course;
import com.springbootassignment.cruddemo.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest
class CourseControllerTest {

    @Mock
    private CourseService courseService;

    @Mock
    private Model model;

    @InjectMocks
    private CourseController courseController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listCourse_ShouldReturnListOfCoursesAndCorrectViewName() {
        // Arrange
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1, "Course 1"));
        courses.add(new Course(2, "Course 2"));

        when(courseService.findAll()).thenReturn(courses);

        // Act
        String viewName = courseController.listCourse(model);

        // Assert
        assertEquals("list-course", viewName);
        verify(model).addAttribute("courses", courses);
        verify(courseService).findAll();
    }

    @Test
    void showFormForAdd_ShouldReturnCorrectViewName() {
        // Act
        String viewName = courseController.showFormForAdd(model);

        // Assert
        assertEquals("courses/course-form", viewName);
        verify(model).addAttribute(eq("course"), any(Course.class));
    }

    @Test
    void saveCourse_ShouldSaveCourseAndRedirectToList() {
        // Arrange
        Course course = new Course(1, "Course 1");

        // Act
        String viewName = courseController.saveCourse(course);

        // Assert
        assertEquals("redirect:/courses/list", viewName);
        verify(courseService).save(course);
    }

    @Test
    void showFormForUpdate_ShouldReturnCorrectViewNameAndCourse() {
        // Arrange
        int courseId = 1;
        Course course = new Course(courseId, "Course 1");

        when(courseService.findById(courseId)).thenReturn(course);

        // Act
        String viewName = courseController.showFormForUpdate(courseId, model);

        // Assert
        assertEquals("courses/course-form", viewName);
        verify(model).addAttribute("course", course);
    }

    @Test
    void delete_ShouldDeleteCourseAndRedirectToList() {
        // Arrange
        int courseId = 1;

        // Act
        String viewName = courseController.delete(courseId);

        // Assert
        assertEquals("redirect:/courses/list", viewName);
        verify(courseService).deleteById(courseId);
    }


}
