package com.tka.dao;

import java.util.List;
import com.tka.entity.Subject;

public interface SubjectDAO {
	List<Subject> getAllSubjects();

	Subject getSubjectById(Long id);

	void saveSubject(Subject subject);

	void deleteSubject(Long id);
}
