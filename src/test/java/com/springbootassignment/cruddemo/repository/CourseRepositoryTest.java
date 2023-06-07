package com.springbootassignment.cruddemo.repository;

import com.springbootassignment.cruddemo.entity.Course;
import com.springbootassignment.cruddemo.repository.CourseRepository;
import com.springbootassignment.cruddemo.service.CourseServiceImpl;
import org.junit.jupiter.api.Assertions;
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
class CourseRepositoryTest {

    @Mock
    private CourseRepository courseRepository;


    @Test
    void findAllByOrderByTitleAsc_ShouldReturnListOfCourses() {
        // Mock the behavior of the courseRepository.findAllByOrderByTitleAsc() method
        List<Course> mockCourses = new ArrayList<>();
        mockCourses.add(new Course(1, "Course 1"));
        mockCourses.add(new Course(2, "Course 2"));
        when(courseRepository.findAllByOrderByTitleAsc()).thenReturn(mockCourses);

        // Call the method under test
        List<Course> result = courseRepository.findAllByOrderByTitleAsc();

        // Verify the expected behavior
        verify(courseRepository, times(1)).findAllByOrderByTitleAsc();
        Assertions.assertEquals(mockCourses, result);
    }

    @Test
    void findByIdIn_ShouldReturnListOfCourses() {
        List<Integer> courseIds = List.of(1, 2, 3);
        List<Course> mockCourses = new ArrayList<>();
        mockCourses.add(new Course(1, "Course 1"));
        mockCourses.add(new Course(2, "Course 2"));
        when(courseRepository.findByIdIn(courseIds)).thenReturn(mockCourses);

        List<Course> result = courseRepository.findByIdIn(courseIds);

        verify(courseRepository, times(1)).findByIdIn(courseIds);
        Assertions.assertEquals(mockCourses, result);
    }

}
