package com.tka.service;

import java.util.List;
import com.tka.entity.Subject;

public interface SubjectService {
    List<Subject> getAllSubjects();
    Subject getSubjectById(Long id);
    void saveSubject(Subject subject);
    void deleteSubject(Long id);
}
