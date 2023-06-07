package com.springbootassignment.cruddemo.controller;

import com.springbootassignment.cruddemo.entity.Course;
import com.springbootassignment.cruddemo.entity.Student;
import com.springbootassignment.cruddemo.service.CourseService;
import com.springbootassignment.cruddemo.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/students")
public class StudentController {


    private StudentService studentService;
    private CourseService courseService;

    @Autowired
    public StudentController(StudentService theStudentService, CourseService theCourseService){
        studentService = theStudentService;
        courseService  = theCourseService;
    }


    @GetMapping("/list")
    public String listStudent(Model theModel){

        List<Student> theStudents = studentService.findAll();

        theModel.addAttribute("students" , theStudents);
        return "list-students";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        Student theStudent = new Student();
        List<Course> courses = courseService.findAll();

        theModel.addAttribute("student" , theStudent);
        theModel.addAttribute("courses",courses);

        return "students/student-form";
    }



    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

        Student theStudent = studentService.findById(theId);


        List<Course> courses = courseService.findAll();

        List<Integer> selectedCourseIds = theStudent.getCourses()
                .stream()
                .map(Course::getId)
                .collect(Collectors.toList());

        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("courses", courses);
        theModel.addAttribute("selectedCourseIds", selectedCourseIds);

        return "students/student-form";
    }


    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student theStudent,
                              @RequestParam("courseIds") List<Integer> courseIds) {


        List<Course> courses = courseService.findByIdIn(courseIds);

        theStudent.setCourses(courses);

        studentService.save(theStudent);

        return "redirect:/students/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int theId){
        studentService.deleteById(theId);
        return "redirect:/students/list";
    }



}
