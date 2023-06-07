package com.springbootassignment.cruddemo.service;

import com.springbootassignment.cruddemo.entity.Student;
import com.springbootassignment.cruddemo.repository.StudentRepository;
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
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }





    @Test
    void findById_NonExistingId_ShouldThrowRuntimeException() {
        int studentId = 1;
        when(studentRepository.findById(studentId)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> {
            studentService.findById(studentId);
        });

        verify(studentRepository, times(1)).findById(studentId);
    }



    @Test
    void deleteById_ShouldInvokeRepositoryDeleteByIdMethod() {
        int studentId = 1;

        studentService.deleteById(studentId);

        verify(studentRepository, times(1)).deleteById(studentId);
    }

    // Add more test cases for other methods if needed

}
