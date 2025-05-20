package com.tka.controller;

import com.tka.entity.Classroom;
import com.tka.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;

	// Get all classrooms
	@GetMapping("/")
	public ResponseEntity<List<Classroom>> getAllClassrooms() {
		List<Classroom> classrooms = classroomService.getAllClassrooms();
		return new ResponseEntity<>(classrooms, HttpStatus.OK);
	}

	// Get a specific classroom by ID
	@GetMapping("/{id}")
	public ResponseEntity<Classroom> getClassroomById(@PathVariable Long id) {
		Classroom classroom = classroomService.getClassroomById(id);
		if (classroom != null) {
			return new ResponseEntity<>(classroom, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Create a new classroom
	@PostMapping
	public ResponseEntity<Classroom> createClassroom(@RequestBody Classroom classroom) {
		classroomService.saveClassroom(classroom);
		return new ResponseEntity<>(classroom, HttpStatus.CREATED);
	}

	// Update an existing classroom
	@PutMapping("/{id}")
	public ResponseEntity<Classroom> updateClassroom(@PathVariable Long id, @RequestBody Classroom classroom) {
		Classroom existingClassroom = classroomService.getClassroomById(id);
		if (existingClassroom != null) {
			classroom.setId(id); // Ensure the ID is set
			classroomService.saveClassroom(classroom);
			return new ResponseEntity<>(classroom, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete a classroom by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteClassroom(@PathVariable Long id) {
		Classroom existingClassroom = classroomService.getClassroomById(id);
		if (existingClassroom != null) {
			classroomService.deleteClassroom(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
