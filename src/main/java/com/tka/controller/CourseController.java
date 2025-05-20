package com.tka.controller;

import com.tka.entity.Course;
import com.tka.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	// Get all courses
	@GetMapping
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> courses = courseService.getAllCourses();
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	// Get a specific course by ID
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
		Course course = courseService.getCourseById(id);
		if (course != null) {
			return new ResponseEntity<>(course, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Create a new course
	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		courseService.saveCourse(course);
		return new ResponseEntity<>(course, HttpStatus.CREATED);
	}

	// Update an existing course
	@PutMapping("/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
		Course existingCourse = courseService.getCourseById(id);
		if (existingCourse != null) {
			course.setId(id); // Ensure the ID is set
			courseService.saveCourse(course);
			return new ResponseEntity<>(course, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete a course by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
		Course existingCourse = courseService.getCourseById(id);
		if (existingCourse != null) {
			courseService.deleteCourse(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
