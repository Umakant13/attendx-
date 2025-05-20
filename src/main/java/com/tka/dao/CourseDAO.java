package com.tka.dao;

import java.util.List;

import com.tka.entity.Course;

public interface CourseDAO {
	
	List<Course> getAllCourses();
	Course getCourseById(Long id);
	void saveCourse(Course course);
	void deleteCourse(Long id);
}
