package com.tka.controller;

import com.tka.entity.Faculty;
import com.tka.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	// Get all faculties
	@GetMapping
	public ResponseEntity<List<Faculty>> getAllFaculties() {
		List<Faculty> faculties = facultyService.getAllFaculties();
		return new ResponseEntity<>(faculties, HttpStatus.OK);
	}

	// Get a specific faculty by ID
	@GetMapping("/{id}")
	public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
		Faculty faculty = facultyService.getFacultyById(id);
		if (faculty != null) {
			return new ResponseEntity<>(faculty, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Create a new faculty
	@PostMapping
	public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
		facultyService.saveFaculty(faculty);
		return new ResponseEntity<>(faculty, HttpStatus.CREATED);
	}

	// Update an existing faculty
	@PutMapping("/{id}")
	public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
		Faculty existingFaculty = facultyService.getFacultyById(id);
		if (existingFaculty != null) {
			faculty.setId(id); // Ensure the ID is set
			facultyService.saveFaculty(faculty);
			return new ResponseEntity<>(faculty, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete a faculty by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
		Faculty existingFaculty = facultyService.getFacultyById(id);
		if (existingFaculty != null) {
			facultyService.deleteFaculty(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
