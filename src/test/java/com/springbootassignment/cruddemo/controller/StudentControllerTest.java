package com.springbootassignment.cruddemo.controller;

import com.springbootassignment.cruddemo.controller.StudentController;
import com.springbootassignment.cruddemo.entity.Course;
import com.springbootassignment.cruddemo.entity.Student;
import com.springbootassignment.cruddemo.service.CourseService;
import com.springbootassignment.cruddemo.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @Mock
    private CourseService courseService;

    @Mock
    private Model model;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listStudent_ShouldReturnListOfStudentsAndCorrectViewName() {
        // Arrange
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John Doe"));
        students.add(new Student(2, "Jane Smith"));

        when(studentService.findAll()).thenReturn(students);

        // Act
        String viewName = studentController.listStudent(model);

        // Assert
        assertEquals("list-students", viewName);
        verify(model).addAttribute("students", students);
        verify(studentService).findAll();
    }

    @Test
    void showFormForAdd_ShouldReturnCorrectViewNameAndCourses() {
        // Arrange
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1, "Course 1"));
        courses.add(new Course(2, "Course 2"));

        when(courseService.findAll()).thenReturn(courses);

        // Act
        String viewName = studentController.showFormForAdd(model);

        // Assert
        assertEquals("students/student-form", viewName);
        verify(model).addAttribute(eq("student"), any(Student.class));
        verify(model).addAttribute("courses", courses);
    }

    @Test
    void delete_ShouldDeleteStudentAndRedirectToList() {
        // Arrange
        int studentId = 1;

        // Act
        String viewName = studentController.delete(studentId);

        // Assert
        assertEquals("redirect:/students/list", viewName);
        verify(studentService).deleteById(studentId);
    }

    @Test
    void saveStudent_ShouldSaveStudentAndRedirectToListStudentsView() {
        // Arrange
        Student student = new Student();
        List<Integer> courseIds = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        when(courseService.findByIdIn(courseIds)).thenReturn(courses);

        // Act
        String viewName = studentController.saveStudent(student, courseIds);

        // Assert
        assertEquals("redirect:/students/list", viewName);
        verify(studentService).save(student);
        verify(courseService).findByIdIn(courseIds);
    }










}