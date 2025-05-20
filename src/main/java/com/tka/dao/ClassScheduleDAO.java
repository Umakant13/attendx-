package com.tka.dao;

import java.util.List;

import com.tka.entity.ClassSchedule;

public interface ClassScheduleDAO {
	List<ClassSchedule> getAllClassSchedules();
	ClassSchedule getClassScheduleById(Long id);
	void saveClassSchedule(ClassSchedule classSchedule);
	void deleteClassSchedule(Long id);
}
