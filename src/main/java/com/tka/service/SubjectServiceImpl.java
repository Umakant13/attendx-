package com.tka.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tka.dao.SubjectDAO; // Ensure you have this DAO defined
import com.tka.entity.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDAO subjectDAO; // Correct reference to SubjectDAO

    @Override
    @Transactional(readOnly = true)
    public List<Subject> getAllSubjects() {
        return subjectDAO.getAllSubjects(); // Ensure this method is defined in SubjectDAO
    }

    @Override
    @Transactional(readOnly = true)
    public Subject getSubjectById(Long id) {
        return subjectDAO.getSubjectById(id); // Ensure this method is defined in SubjectDAO
    }

    @Override
    @Transactional
    public void saveSubject(Subject subject) {
        subjectDAO.saveSubject(subject); // Ensure this method is defined in SubjectDAO
    }

    @Override
    @Transactional
    public void deleteSubject(Long id) {
        subjectDAO.deleteSubject(id); // Ensure this method is defined in SubjectDAO
    }
}
