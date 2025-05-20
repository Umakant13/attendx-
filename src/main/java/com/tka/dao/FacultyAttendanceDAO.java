package com.tka.dao;

import java.util.List;
import com.tka.entity.FacultyAttendance;

public interface FacultyAttendanceDAO {
    List<FacultyAttendance> getAllFacultyAttendance();
    FacultyAttendance getFacultyAttendanceById(Long id);
    void saveFacultyAttendance(FacultyAttendance facultyAttendance);
    void deleteFacultyAttendance(Long id);
}
