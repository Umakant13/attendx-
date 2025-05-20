package com.tka.service;

import java.util.List;
import com.tka.entity.Faculty;

public interface FacultyService {
    List<Faculty> getAllFaculties();
    Faculty getFacultyById(Long id);
    void saveFaculty(Faculty faculty);
    void deleteFaculty(Long id);
}
