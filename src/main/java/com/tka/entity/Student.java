package com.tka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String rollNumber;

    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @Column(name = "department_id", nullable = false)
    private Long departmentId;

    @Column(nullable = false)
    private String password; // Store hashed passwords
}