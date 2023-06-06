package com.springbootassignment.cruddemo.repository;

import com.springbootassignment.cruddemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course ,Integer> {
    public List<Course> findAllByOrderByTitleAsc();

    List<Course> findByIdIn(List<Integer> courseIds);

}
