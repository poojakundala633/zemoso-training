package com.springbootassignment.cruddemo.service;


import com.springbootassignment.cruddemo.entity.Course;


import java.util.List;

public interface CourseService {

    public List<Course> findAll();

    public Course findById(int theId);

    public void save(Course theCourse);

    public void deleteById(int theId);

    List<Course> findByIdIn(List<Integer> courseIds);

}

