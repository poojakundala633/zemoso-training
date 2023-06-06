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
 class CourseTest {

    private Course course;
    private List<Student> students;

    @BeforeEach
    void setUp() {
        course = new Course();
        course.setId(1);
        course.setTitle("Mathematics");

        students = new ArrayList<>();
        Student student1 = new Student(1, "John");
        Student student2 = new Student(2, "Alice");
        students.add(student1);
        students.add(student2);
        course.setStudents(students);
    }

    @Test
     void testGetId() {
        assertEquals(1, course.getId());
    }

    @Test
     void testSetTitle() {
        course.setTitle("Science");
        assertEquals("Science", course.getTitle());
    }

    @Test
    void testGetStudents() {
        List<Student> retrievedStudents = course.getStudents();
        assertNotNull(retrievedStudents);
        assertEquals(2, retrievedStudents.size());
        assertTrue(retrievedStudents.contains(students.get(0)));
        assertTrue(retrievedStudents.contains(students.get(1)));
    }

    @Test
     void testSetStudents() {
        List<Student> newStudents = new ArrayList<>();
        Student student3 = new Student(3, "Bob");
        newStudents.add(student3);
        course.setStudents(newStudents);

        List<Student> retrievedStudents = course.getStudents();
        assertNotNull(retrievedStudents);
        assertEquals(1, retrievedStudents.size());
        assertTrue(retrievedStudents.contains(student3));
    }

    @Test
     void testToString() {
        String expectedString = "Course{" +
                "id=1, " +
                "title='Mathematics', " +
                "course_id=null, " +
                "students=[" + students.get(0) + ", " + students.get(1) + "]}";
        assertEquals(expectedString, course.toString());
    }




        @Test
        void testCourseConstructorAndGetters() {
            int courseId = 1;
            String title = "Mathematics";

            Course course = new Course(courseId, title);

            assertEquals(courseId, course.getId());
            assertEquals(title, course.getTitle());
            assertNull(course.getCourse_id());
            assertNull(course.getStudents());
        }

        @Test
        void testSettersAndGetters() {
            Course course = new Course();

            int courseId = 1;
            String title = "Mathematics";
            Integer course_id = 123;
            List<Student> students = new ArrayList<>();

            course.setId(courseId);
            course.setTitle(title);
            course.setCourse_id(course_id);
            course.setStudents(students);

            assertEquals(courseId, course.getId());
            assertEquals(title, course.getTitle());
            assertEquals(course_id, course.getCourse_id());
            assertEquals(students, course.getStudents());
        }



}
