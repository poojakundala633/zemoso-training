package com.springbootassignment.cruddemo.service;

import com.springbootassignment.cruddemo.entity.Course;
import com.springbootassignment.cruddemo.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll_ShouldReturnListOfCourses() {
        // Mock the behavior of the courseRepository.findAllByOrderByTitleAsc() method
        List<Course> mockCourses = new ArrayList<>();
        mockCourses.add(new Course(1, "Course 1"));
        mockCourses.add(new Course(2, "Course 2"));
        when(courseRepository.findAllByOrderByTitleAsc()).thenReturn(mockCourses);

        // Call the method under test
        List<Course> result = courseService.findAll();

        // Verify the expected behavior
        verify(courseRepository, times(1)).findAllByOrderByTitleAsc();
        Assertions.assertEquals(mockCourses, result);
    }

    @Test
    void findById_ExistingId_ShouldReturnCourse() {
        int courseId = 1;
        Course mockCourse = new Course(courseId, "Course 1");
        when(courseRepository.findById(courseId)).thenReturn(Optional.of(mockCourse));

        Course result = courseService.findById(courseId);

        verify(courseRepository, times(1)).findById(courseId);
        Assertions.assertEquals(mockCourse, result);
    }

    @Test
    void findById_NonExistingId_ShouldThrowRuntimeException() {
        int courseId = 1;
        when(courseRepository.findById(courseId)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> {
            courseService.findById(courseId);
        });

        verify(courseRepository, times(1)).findById(courseId);
    }

    @Test
    void save_ShouldInvokeRepositorySaveMethod() {
        Course course = new Course(1, "Course 1");

        courseService.save(course);

        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void deleteById_ShouldInvokeRepositoryDeleteByIdMethod() {
        int courseId = 1;

        courseService.deleteById(courseId);

        verify(courseRepository, times(1)).deleteById(courseId);
    }

    // Add more test cases for other methods if needed

}
