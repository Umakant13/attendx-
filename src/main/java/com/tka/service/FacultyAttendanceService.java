package com.tka.service;

import java.util.List;
import com.tka.entity.FacultyAttendance;

public interface FacultyAttendanceService {
    List<FacultyAttendance> getAllFacultyAttendance();
    FacultyAttendance getFacultyAttendanceById(Long id);
    void saveFacultyAttendance(FacultyAttendance facultyAttendance);
    void deleteFacultyAttendance(Long id);
}
