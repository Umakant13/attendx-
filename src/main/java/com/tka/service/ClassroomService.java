package com.tka.service;

import java.util.List;

import com.tka.entity.Classroom;

public interface ClassroomService {
	
	List<Classroom> getAllClassrooms();
	Classroom getClassroomById(Long id);
	void saveClassroom(Classroom classroom);
	void deleteClassroom(Long id);

}
