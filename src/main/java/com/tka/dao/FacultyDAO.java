package com.tka.dao;

import java.util.List;

import com.tka.entity.Faculty;


public interface FacultyDAO {
    List<Faculty> getAllFaculty();
    Faculty getFacultyById(Long id);
    void saveFaculty(Faculty faculty);
    void deleteFaculty(Long id);
}
