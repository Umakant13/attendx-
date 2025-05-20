package com.tka.service;


import java.util.List;
import com.tka.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void saveStudent(Student student);
    void deleteStudent(Long id);
}