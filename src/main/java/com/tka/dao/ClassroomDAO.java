package com.tka.dao;

import java.util.List;

import com.tka.entity.Classroom;

public interface ClassroomDAO {
	List<Classroom> getAllClassrooms();
	Classroom getClassroomById(Long id);
	void saveClassroom(Classroom classroom);
	void deleteClassroom(Long id);
}
