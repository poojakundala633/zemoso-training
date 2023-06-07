package com.springbootassignment.cruddemo.repository;

import com.springbootassignment.cruddemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findAllByOrderByLastNameAsc();
}
