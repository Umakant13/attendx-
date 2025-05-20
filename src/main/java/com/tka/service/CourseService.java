package com.tka.service;

import java.util.List;
import com.tka.entity.Course;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    void saveCourse(Course course);
    void deleteCourse(Long id);
}
