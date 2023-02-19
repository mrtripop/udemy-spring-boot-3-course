package com.spring.udemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.udemy.interfaces.ICourse;
import com.spring.udemy.model.Course;
import com.spring.udemy.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController implements ICourse {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @Override
    @GetMapping("{id}")
    public Course getById(@PathVariable("id") int id) {
        return courseService.getById(id);
    }

    @Override
    @PostMapping
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @Override
    @PutMapping
    public Course update(@RequestBody Course course) {
        return courseService.update(course);
    }

    @Override
    @DeleteMapping
    public Course delete(@RequestBody Course course) {
        return courseService.delete(course);
    }

}
