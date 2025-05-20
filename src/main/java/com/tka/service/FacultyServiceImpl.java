package com.tka.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tka.dao.FacultyDAO; // Ensure you have this DAO defined
import com.tka.entity.Faculty;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyDAO facultyDAO; // Correct reference to FacultyDAO

    @Override
    @Transactional(readOnly = true)
    public List<Faculty> getAllFaculties() {
        return facultyDAO.getAllFaculty(); // Ensure this method is defined in FacultyDAO
    }

    @Override
    @Transactional(readOnly = true)
    public Faculty getFacultyById(Long id) {
        return facultyDAO.getFacultyById(id); // Ensure this method is defined in FacultyDAO
    }

    @Override
    @Transactional
    public void saveFaculty(Faculty faculty) {
        facultyDAO.saveFaculty(faculty); // Ensure this method is defined in FacultyDAO
    }

    @Override
    @Transactional
    public void deleteFaculty(Long id) {
        facultyDAO.deleteFaculty(id); // Ensure this method is defined in FacultyDAO
    }
}
