package com.tka.controller;

import com.tka.entity.Department;
import com.tka.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	// Get all departments
	@GetMapping
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> departments = departmentService.getAllDepartments();
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	// Get a specific department by ID
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
		Department department = departmentService.getDepartmentById(id);
		if (department != null) {
			return new ResponseEntity<>(department, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Create a new department
	@PostMapping
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		departmentService.saveDepartment(department);
		return new ResponseEntity<>(department, HttpStatus.CREATED);
	}

	// Update an existing department
	@PutMapping("/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
		Department existingDepartment = departmentService.getDepartmentById(id);
		if (existingDepartment != null) {
			department.setId(id); // Ensure the ID is set
			departmentService.saveDepartment(department);
			return new ResponseEntity<>(department, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete a department by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
		Department existingDepartment = departmentService.getDepartmentById(id);
		if (existingDepartment != null) {
			departmentService.deleteDepartment(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
