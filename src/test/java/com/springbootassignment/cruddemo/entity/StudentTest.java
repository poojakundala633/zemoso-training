package com.springbootassignment.cruddemo.entity;

import com.springbootassignment.cruddemo.entity.Course;
import com.springbootassignment.cruddemo.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
 class StudentTest {

    private Student student;
    private List<Course> courses;

    @BeforeEach
     void setUp() {
        student = new Student();
        student.setId(1);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");

        courses = new ArrayList<>();
        Course course1 = new Course(1, "Mathematics");
        Course course2 = new Course(2, "Science");
        courses.add(course1);
        courses.add(course2);
        student.setCourses(courses);
    }

    @Test
     void testGetId() {
        assertEquals(1, student.getId());
    }

    @Test
     void testSetFirstName() {
        student.setFirstName("Alice");
        assertEquals("Alice", student.getFirstName());
    }

    @Test
     void testGetLastName() {
        assertEquals("Doe", student.getLastName());
    }

    @Test
     void testSetEmail() {
        student.setEmail("alice@example.com");
        assertEquals("alice@example.com", student.getEmail());
    }

    @Test
     void testGetCourses() {
        List<Course> retrievedCourses = student.getCourses();
        assertNotNull(retrievedCourses);
        assertEquals(2, retrievedCourses.size());
        assertTrue(retrievedCourses.contains(courses.get(0)));
        assertTrue(retrievedCourses.contains(courses.get(1)));
    }

    @Test
     void testSetCourses() {
        List<Course> newCourses = new ArrayList<>();
        Course course3 = new Course(3, "History");
        newCourses.add(course3);
        student.setCourses(newCourses);

        List<Course> retrievedCourses = student.getCourses();
        assertNotNull(retrievedCourses);
        assertEquals(1, retrievedCourses.size());
        assertTrue(retrievedCourses.contains(course3));
    }

   @Test
   public void testGettersAndSetters() {
      // Arrange
      int id = 1;
      String firstName = "John";
      String lastName = "Doe";
      String email = "johndoe@example.com";
      String title = "Mr.";

      // Act
      Student student = new Student();
      student.setId(id);
      student.setFirstName(firstName);
      student.setLastName(lastName);
      student.setEmail(email);
      student.setTitle(title);

      // Assert
      assertEquals(id, student.getId());
      assertEquals(firstName, student.getFirstName());
      assertEquals(lastName, student.getLastName());
      assertEquals(email, student.getEmail());
      assertEquals(title, student.getTitle());
   }

   @Test
   public void testEmptyConstructor() {
      // Arrange & Act
      Student student = new Student();

      // Assert
      assertNull(student.getFirstName());
      assertNull(student.getLastName());
      assertNull(student.getEmail());
      assertNull(student.getTitle());
      assertNull(student.getCourses());
   }

   @Test
   public void testToString() {
      // Arrange
      int id = 1;
      String firstName = "John";
      String lastName = "Doe";
      String email = "johndoe@example.com";
      String title = "Mr.";

      Student student = new Student(id, firstName, lastName, email);
      student.setTitle(title);

      // Act
      String result = student.toString();

      // Assert
      String expected = "Student{id=1, firstName='John', lastName='Doe', email='johndoe@example.com', title='Mr.', courses=[]}";
      assertEquals(expected, result);
   }




}
