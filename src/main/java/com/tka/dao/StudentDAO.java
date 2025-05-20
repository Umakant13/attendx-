package com.tka.dao;


import java.util.List;
import com.tka.entity.Student;

public interface StudentDAO {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void saveStudent(Student student);
    void deleteStudent(Long id);
}