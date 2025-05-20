package com.tka.service;

import java.util.List;

import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tka.dao.ClassroomDAO;
import com.tka.entity.Classroom;

@Service
public class ClassroomServiceImpl implements ClassroomService {

	@Autowired
	private ClassroomDAO classroomDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Classroom> getAllClassrooms() {
		// TODO Auto-generated method stub
		return classroomDAO.getAllClassrooms();
	}

	@Override
	@Transactional(readOnly = true)
	public Classroom getClassroomById(Long id) {
		// TODO Auto-generated method stub
		return classroomDAO.getClassroomById(id);
	}

	@Override
	@Transactional
	public void saveClassroom(Classroom classroom) {
		// TODO Auto-generated method stub
		classroomDAO.saveClassroom(classroom);
	}

	@Override
	@Transactional
	public void deleteClassroom(Long id) {
		// TODO Auto-generated method stub
		classroomDAO.deleteClassroom(id);
	}
	 

}
