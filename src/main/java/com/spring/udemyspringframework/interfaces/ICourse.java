package com.spring.udemyspringframework.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.udemyspringframework.pojo.Course;

@Component
public interface ICourse {

    public List<Course> getAll();

    public Course getById(int id);

    public Course save(Course course);

    public Course update(Course course);

    public Course delete(Course course);
}
