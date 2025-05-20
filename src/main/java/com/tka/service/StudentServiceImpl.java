package com.tka.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tka.dao.StudentDAO;
import com.tka.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional(readOnly = true)
    public Student getStudentById(Long id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentDAO.deleteStudent(id);
    }
}