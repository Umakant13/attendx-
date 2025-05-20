package com.tka.controller;

import com.tka.entity.FacultyAttendance;
import com.tka.service.FacultyAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facultyAttendance")
public class FacultyAttendanceController {

	@Autowired
	private FacultyAttendanceService facultyAttendanceService;

	// Get all faculty attendance records
	@GetMapping
	public ResponseEntity<List<FacultyAttendance>> getAllFacultyAttendance() {
		List<FacultyAttendance> attendanceRecords = facultyAttendanceService.getAllFacultyAttendance();
		return new ResponseEntity<>(attendanceRecords, HttpStatus.OK);
	}

	// Get a specific faculty attendance record by ID
	@GetMapping("/{id}")
	public ResponseEntity<FacultyAttendance> getFacultyAttendanceById(@PathVariable Long id) {
		FacultyAttendance attendance = facultyAttendanceService.getFacultyAttendanceById(id);
		if (attendance != null) {
			return new ResponseEntity<>(attendance, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Create a new faculty attendance record
	@PostMapping
	public ResponseEntity<FacultyAttendance> createFacultyAttendance(@RequestBody FacultyAttendance facultyAttendance) {
		facultyAttendanceService.saveFacultyAttendance(facultyAttendance);
		return new ResponseEntity<>(facultyAttendance, HttpStatus.CREATED);
	}

	// Update an existing faculty attendance record
	@PutMapping("/{id}")
	public ResponseEntity<FacultyAttendance> updateFacultyAttendance(@PathVariable Long id,
			@RequestBody FacultyAttendance facultyAttendance) {
		FacultyAttendance existingAttendance = facultyAttendanceService.getFacultyAttendanceById(id);
		if (existingAttendance != null) {
			facultyAttendance.setId(id); // Ensure the ID is set
			facultyAttendanceService.saveFacultyAttendance(facultyAttendance);
			return new ResponseEntity<>(facultyAttendance, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete a faculty attendance record by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFacultyAttendance(@PathVariable Long id) {
		FacultyAttendance existingAttendance = facultyAttendanceService.getFacultyAttendanceById(id);
		if (existingAttendance != null) {
			facultyAttendanceService.deleteFacultyAttendance(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
