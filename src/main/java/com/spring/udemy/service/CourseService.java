package com.spring.udemy.service;

import com.spring.udemy.interfaces.ICourse;
import com.spring.udemy.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class CourseService implements ICourse {
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
            log.error("[get-all] ", error);
            return null;
        }
    }

    @Override
    @Transactional
    public Course getById(int id) {
        log.info(String.valueOf(id));
        try {
            Course response = session.find(Course.class, id);
            return response;
        } catch (IllegalArgumentException error) {
            log.error("[get-by-id]", error);
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
            log.error(IMPORTANT_MARKER, "[save] -> ", error);
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
            log.error("[update] ", error);
            return null;
        }
    }

    @Override
    @Transactional
    public Course delete(Course course) {
        try {
            log.info(course.toString());
            log.info(String.valueOf(session.contains(course)));
            if (session.contains(course)) {
                session.remove(course);
                return course;
            } else {
                session.merge(course);
                session.remove(course);
                return null;
            }
        } catch (Exception error) {
            log.error("[delete] ", error);
            return null;
        }
    }
}
