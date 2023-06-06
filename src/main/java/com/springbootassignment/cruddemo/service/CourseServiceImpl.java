package com.springbootassignment.cruddemo.service;

import com.springbootassignment.cruddemo.entity.Course;
import com.springbootassignment.cruddemo.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository theCourseRepository) {
        courseRepository = theCourseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAllByOrderByTitleAsc();
    }

    @Override
    public Course findById(int theId) {
        Optional<Course> result = courseRepository.findById(theId);

        Course theCourse = null;

        if (result.isPresent()) {
            theCourse = result.get();
        } else {
            throw new RuntimeException("Did not find the course id - " + theId);
        }

        return theCourse;
    }

    @Override
    public void save(Course theCourse) {
        courseRepository.save(theCourse);
    }

    @Override
    public void deleteById(int theId) {
        courseRepository.deleteById(theId);
    }

    @Override
    public List<Course> findByIdIn(List<Integer> courseIds) {
        return courseRepository.findByIdIn(courseIds);
    }
}
