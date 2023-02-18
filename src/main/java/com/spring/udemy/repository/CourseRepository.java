package com.spring.udemy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.udemy.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Serializable> {

}
