package com.spring.udemyspringframework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.udemyspringframework.interfaces.ICourse;
import com.spring.udemyspringframework.pojo.Course;
import com.spring.udemyspringframework.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CourseController implements ICourse {

    @Autowired
    private CourseService courseService;

    @Override
    @GetMapping("/course")
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @Override
    @GetMapping("/course/{id}")
    public Course getById(@PathVariable("id") int id) {
        return courseService.getById(id);
    }

    @Override
    @PostMapping("/course/save")
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @Override
    @PutMapping("/course/update")
    public Course update(@RequestBody Course course) {
        return courseService.update(course);
    }

    @Override
    @DeleteMapping("/course/delete")
    public Course delete(@RequestBody Course course) {
        return courseService.delete(course);
    }

}
