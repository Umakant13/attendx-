package com.tka.service;

import java.util.List;
import com.tka.entity.ClassSchedule;

public interface ClassScheduleService {
    List<ClassSchedule> getAllClassSchedules();
    ClassSchedule getClassScheduleById(Long id);
    void saveClassSchedule(ClassSchedule classSchedule);
    void deleteClassSchedule(Long id);
}
