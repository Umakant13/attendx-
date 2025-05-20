package com.tka.controller;

import com.tka.entity.Subject;
import com.tka.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	// Get all subjects
	@GetMapping
	public ResponseEntity<List<Subject>> getAllSubjects() {
		List<Subject> subjects = subjectService.getAllSubjects();
		return new ResponseEntity<>(subjects, HttpStatus.OK);
	}

	// Get a specific subject by ID
	@GetMapping("/{id}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
		Subject subject = subjectService.getSubjectById(id);
		if (subject != null) {
			return new ResponseEntity<>(subject, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Create a new subject
	@PostMapping
	public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
		subjectService.saveSubject(subject);
		return new ResponseEntity<>(subject, HttpStatus.CREATED);
	}

	// Update an existing subject
	@PutMapping("/{id}")
	public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
		Subject existingSubject = subjectService.getSubjectById(id);
		if (existingSubject != null) {
			subject.setId(id); // Ensure the ID is set
			subjectService.saveSubject(subject);
			return new ResponseEntity<>(subject, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete a subject by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
		Subject existingSubject = subjectService.getSubjectById(id);
		if (existingSubject != null) {
			subjectService.deleteSubject(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
