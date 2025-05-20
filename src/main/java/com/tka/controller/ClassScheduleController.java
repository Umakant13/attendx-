package com.tka.controller;

import com.tka.entity.ClassSchedule;
import com.tka.service.ClassScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classSchedules")
public class ClassScheduleController {

    @Autowired
    private ClassScheduleService classScheduleService;

    // Get all class schedules
    @GetMapping
    public ResponseEntity<List<ClassSchedule>> getAllClassSchedules() {
        List<ClassSchedule> classSchedules = classScheduleService.getAllClassSchedules();
        return new ResponseEntity<>(classSchedules, HttpStatus.OK);
    }

    // Get a specific class schedule by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClassSchedule> getClassScheduleById(@PathVariable Long id) {
        ClassSchedule classSchedule = classScheduleService.getClassScheduleById(id);
        if (classSchedule != null) {
            return new ResponseEntity<>(classSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new class schedule
    @PostMapping
    public ResponseEntity<ClassSchedule> createClassSchedule(@RequestBody ClassSchedule classSchedule) {
        classScheduleService.saveClassSchedule(classSchedule);
        return new ResponseEntity<>(classSchedule, HttpStatus.CREATED);
    }

    // Update an existing class schedule
    @PutMapping("/{id}")
    public ResponseEntity<ClassSchedule> updateClassSchedule(@PathVariable Long id, @RequestBody ClassSchedule classSchedule) {
        ClassSchedule existingClassSchedule = classScheduleService.getClassScheduleById(id);
        if (existingClassSchedule != null) {
            classSchedule.setId(id); // Ensure the ID is set
            classScheduleService.saveClassSchedule(classSchedule);
            return new ResponseEntity<>(classSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a class schedule by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassSchedule(@PathVariable Long id) {
        ClassSchedule existingClassSchedule = classScheduleService.getClassScheduleById(id);
        if (existingClassSchedule != null) {
            classScheduleService.deleteClassSchedule(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
