package com.spring.udemy.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.udemy.model.Course;

@Component
public interface ICourse {

    List<Course> getAll();

    Course getById(int id);

    Course save(Course course);

    Course update(Course course);

    Course delete(Course course);
}
