package com.springbootassignment.cruddemo.controller;

import com.springbootassignment.cruddemo.entity.Course;
import com.springbootassignment.cruddemo.entity.Student;
import com.springbootassignment.cruddemo.service.CourseService;
import com.springbootassignment.cruddemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService theCourseService){
        courseService = theCourseService;
    }

    @GetMapping("/list")
    public String listCourse(Model theModel) {
        List<Course> theCourses = courseService.findAll();
        theModel.addAttribute("courses", theCourses);
        return "list-course";
    }



    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "courses/course-form";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);
        return "redirect:/courses/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("courseId") int theId,
                                    Model theModel) {

        Course theCourse = courseService.findById(theId);

        theModel.addAttribute("course", theCourse);

        return "courses/course-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("courseId") int theId){
        courseService.deleteById(theId);
        return "redirect:/courses/list";
    }


}
