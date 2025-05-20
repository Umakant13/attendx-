package com.tka.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tka.dao.DepartmentDAO;
import com.tka.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    @Override
    @Transactional(readOnly = true)
    public Department getDepartmentById(Long id) {
        return departmentDAO.getDepartmentById(id);
    }

    @Override
    @Transactional
    public void saveDepartment(Department department) {
        departmentDAO.saveDepartment(department);
    }

    @Override
    @Transactional
    public void deleteDepartment(Long id) {
        departmentDAO.deleteDepartment(id);
    }
}
