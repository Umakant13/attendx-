package com.tka.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tka.dao.FacultyAttendanceDAO; // Correct reference to FacultyAttendanceDao
import com.tka.entity.FacultyAttendance;

@Service
public class FacultyAttendanceServiceImpl implements FacultyAttendanceService {

    @Autowired
    private FacultyAttendanceDAO facultyAttendanceDao; // Using the correct DAO name

    @Override
    @Transactional(readOnly = true)
    public List<FacultyAttendance> getAllFacultyAttendance() {
        return facultyAttendanceDao.getAllFacultyAttendance(); // Implement this method in DAO
    }

    @Override
    @Transactional(readOnly = true)
    public FacultyAttendance getFacultyAttendanceById(Long id) {
        return facultyAttendanceDao.getFacultyAttendanceById(id); // Implement this method in DAO
    }

    @Override
    @Transactional
    public void saveFacultyAttendance(FacultyAttendance facultyAttendance) {
        facultyAttendanceDao.saveFacultyAttendance(facultyAttendance); // Implement this method in DAO
    }

    @Override
    @Transactional
    public void deleteFacultyAttendance(Long id) {
        facultyAttendanceDao.deleteFacultyAttendance(id); // Implement this method in DAO
    }
}
