package com.spring.udemy.service;

import java.util.List;
import javax.transaction.Transactional;

import com.spring.udemy.interfaces.ICourse;
import com.spring.udemy.model.Course;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourse {
    private static Logger logger = LoggerFactory.getLogger(CourseService.class);
    private static final Marker IMPORTANT_MARKER = MarkerFactory.getMarker("IMPORTANT");

    @Autowired
    private Session session;

    @Override
    @Transactional
    public List<Course> getAll() {
        try {
            List<Course> response = session.createQuery("SELECT c FROM Course c", Course.class)
                    .getResultList();
            return response;
        } catch (Exception error) {
            logger.error("[get-all] ", error);
            return null;
        }
    }

    @Override
    @Transactional
    public Course getById(int id) {
        logger.info(String.valueOf(id));
        try {
            Course response = session.find(Course.class, id);
            return response;
        } catch (IllegalArgumentException error) {
            logger.error("[get-by-id]", error);
            return null;
        }
    }

    @Override
    @Transactional
    public Course save(Course course) {
        try {
            session.save(course);
            return course;
        } catch (Exception error) {
            logger.error(IMPORTANT_MARKER, "[save] -> ", error);
            return null;
        }
    }

    @Override
    @Transactional
    public Course update(Course course) {
        try {
            session.merge(course);
            return course;
        } catch (Exception error) {
            logger.error("[update] ", error);
            return null;
        }
    }

    @Override
    @Transactional
    public Course delete(Course course) {
        try {
            logger.info(course.toString());
            logger.info(String.valueOf(session.contains(course)));
            if (session.contains(course)) {
                session.remove(course);
                return course;
            } else {
                session.merge(course);
                session.remove(course);
                return null;
            }
        } catch (Exception error) {
            logger.error("[delete] ", error);
            return null;
        }
    }
}
